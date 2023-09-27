package br.com.api.prova.controller;

import br.com.api.prova.dto.TarefaDTO;
import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.entity.TarefaEntity;
import br.com.api.prova.service.tarefas.TarefasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/gerenciamento/tarefas", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "Tarefas Controller")
public class TarefasController {

    @Autowired
    TarefasService service;


    @Operation(summary = "Retorna a lista de todas as tarefas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping("/obter-todos")
    public ResponseEntity<List<TarefaEntity>> obterTodasTarefas() {
        return new ResponseEntity<>(service.getTodasTarefas(), HttpStatus.OK);
    }


    @Operation(summary = "Adiciona uma tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<Optional<TarefaEntity>> adicionarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return new ResponseEntity<>(service.adicionarTarefa(tarefaDTO), HttpStatus.CREATED);
    }


    @Operation(summary = "Altera uma tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<TarefaEntity> alterarTarefa(
            @PathVariable("id") long id,
            @RequestBody TarefaDTO tarefaDTO) {
        return new ResponseEntity<>(service.alterarTarefa(id, tarefaDTO), HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Aloca uma pessoa na tarefa que tenha o mesmo departamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/alocar/{id}")
    public ResponseEntity<PessoaEntity> alocarPessoa(
            @PathVariable("id") long pessoaId,
            @RequestParam("tarefaId") long tarefaId) {
        service.alocarPessoa(pessoaId, tarefaId);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Finaliza uma tarefa com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/tarefas/finalizar/{id}")
    public ResponseEntity<TarefaEntity> finalizarTarefa(
            @PathVariable("id") long id,
            @RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok(service.finalizarTarefa(id, tarefaDTO));
    }


    @Operation(summary = "Delete uma tarefa específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @DeleteMapping( "/{id}")
    public ResponseEntity<?> removerTarefa(
            @PathVariable("id") long id) {
        service.removerTarefa(id);
        return new ResponseEntity<>("Tarefa selecionada foi removida", HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Deleta todas as tarefas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @DeleteMapping( "/remover-todos")
    public ResponseEntity<?> removerTodasTarefas() {
        service.removerTodasTarefas();
        return new ResponseEntity<>("Todas as tarefas foram removidas", HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Lista 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping("/pendentes")
    public ResponseEntity<List<TarefaEntity>> semPessoaAlocada() {
        List<TarefaEntity> semPessoaAlocada = service.getPessoaNaoAlocada();
        return new ResponseEntity<>(semPessoaAlocada, HttpStatus.OK);
    }
}

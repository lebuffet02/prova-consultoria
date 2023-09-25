package br.com.api.prova.controller;

import br.com.api.prova.DTO.record.Tarefas;
import br.com.api.prova.db.entity.TarefaEntity;
import br.com.api.prova.service.tarefas.TarefasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/gerenciamento/tarefas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TarefasController {

    @Autowired
    TarefasService service;

    @Operation(summary = "Adiciona uma tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<Tarefas> adicionarTarefa(@RequestBody Tarefas tarefasDTO) {
        return new ResponseEntity<>(service.adicionarTarefa(tarefasDTO), HttpStatus.CREATED);
    }


    @Operation(summary = "Altera uma tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> alterarTarefa(
            @PathVariable("id") long id,
            @RequestBody Tarefas tarefasDTO) {
        return new ResponseEntity<>(service.alterarTarefa(id, tarefasDTO), HttpStatus.OK);
    }


    @Operation(summary = "Finaliza uma tarefa com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/tarefas/finalizar/{id}")
    public ResponseEntity<?> finalizarTarefa(
            @PathVariable("id") long id,
            @RequestBody Tarefas tarefasDTO) {
        service.finalizarTarefa(id, tarefasDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


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
    @GetMapping("/tarefas/pendentes")
    public ResponseEntity<List<TarefaEntity>> semPessoaAlocada() {
        List<TarefaEntity> semPessoaAlocada = service.getPessoaNaoAlocada();
        return ResponseEntity.ok(semPessoaAlocada);
    }
}

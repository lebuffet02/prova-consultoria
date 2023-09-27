package br.com.api.prova.controller;

import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.dto.PessoaDTO;
import br.com.api.prova.entity.TarefaEntity;
import br.com.api.prova.service.pessoas.PessoasService;
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
@RequestMapping(path = "api/gerenciamento/pessoas", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "Pessoas Controller")
public class PessoasController {

    @Autowired
    PessoasService service;


    @Operation(summary = "Retorna a lista de todas as pessoas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping("/obter-todos")
    public ResponseEntity<List<PessoaEntity>> obterTodos() {
        return new ResponseEntity<>(service.getTodasPessoas(), HttpStatus.OK);
    }

    @Operation(summary = "Adiciona uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<Optional<PessoaEntity>> adicionarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return new ResponseEntity<>(service.adicionarPessoa(pessoaDTO), HttpStatus.CREATED);
    }


    @Operation(summary = "Altera uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
        @PutMapping("/{id}")
    public ResponseEntity<PessoaEntity> alterarPessoa(
            @PathVariable("id") long id,
            @RequestBody PessoaEntity pessoaEntity) {
        return new ResponseEntity<>(service.alterarPessoa(id, pessoaEntity), HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Delete uma pessoa específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @DeleteMapping( "/{id}")
    public ResponseEntity<?> removerPessoa(
            @PathVariable("id") long id) {
        service.removerPessoa(id);
        return new ResponseEntity<>("Usuário selecionado foi removido", HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Deleta todas as pessoas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @DeleteMapping( "/remover-todos")
    public ResponseEntity<?> removerTodos() {
        service.removerTodos();
        return new ResponseEntity<>("Todos foram removidos", HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Busca pessoas por nome e período, retorna média de horas gastas por tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping("/pendentes/{nome}")
    public ResponseEntity<List<Object[]>> gastos(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(service.buscarMediaHorasPorTarefaPorNome(nome));
    }


    @Operation(summary = "Lista pessoas trazendo nome, departamento, total horas gastas nas tarefas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping
    public  ResponseEntity<List<TarefaEntity>> listarPessoasComTotalHorasGastas() {
        return ResponseEntity.ok(service.findAllByPessoasComTotalHorasGastas());
    }
}

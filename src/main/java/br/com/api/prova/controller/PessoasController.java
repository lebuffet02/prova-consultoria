package br.com.api.prova.controller;

import br.com.api.prova.record.Pessoas;
import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.service.pessoas.PessoasService;
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
@RequestMapping(path = "api/gerenciamento/pessoas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PessoasController {

    @Autowired
    PessoasService service;


    @Operation(summary = "Adiciona uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<Pessoas> adicionarPessoa(@RequestBody Pessoas pessoasDTO) {
        return new ResponseEntity<>(service.adicionarPessoa(pessoasDTO), HttpStatus.CREATED);
    }


    @Operation(summary = "Altera uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> alterarPessoa(
            @PathVariable("id") long id,
            @RequestBody Pessoas pessoasDTO) {
        service.alterarPessoa(id, pessoasDTO);
        return new ResponseEntity<>(service.alterarPessoa(id, pessoasDTO), HttpStatus.NO_CONTENT);
    }


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
        return new ResponseEntity<>(service.buscarMediaHorasPorTarefaPorNome(nome), HttpStatus.OK);
    }


    @Operation(summary = "Aloca uma pessoa na tarefa que tenha o mesmo departamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/alocar/{id}")
    public ResponseEntity<Pessoas> alocarPessoa(
            @PathVariable("id") long pessoaId,
            @RequestParam("tarefaId") long tarefaId) {
        service.alocarPessoa(pessoaId, tarefaId);
        return ResponseEntity.noContent().build();
    }


//    @Operation(summary = "Lista pessoas trazendo nome, departamento, total horas gastas nas tarefas")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
//            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
//            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
//            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
//    })
//    @GetMapping
//    public  ResponseEntity<List<Object[]>> listarPessoas() {
//        return ResponseEntity.ok(service.findAllByPessoasComTotalHorasGastas());
//    }
}

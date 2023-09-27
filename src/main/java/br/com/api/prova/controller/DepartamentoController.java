package br.com.api.prova.controller;

import br.com.api.prova.dto.DepartamentoDTO;
import br.com.api.prova.entity.DepartamentoEntity;
import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.service.departamentos.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departamentos")
@Tag(name = "Departamento Controller")
public class DepartamentoController  {

    @Autowired
    DepartamentoService service;


    @Operation(summary = "Retorna a lista de todas as pessoas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping("/obter-todos")
    public ResponseEntity<List<DepartamentoEntity>> obterTodos() {
        return ResponseEntity.ok(service.getTodosDepartamentos());
    }

    @Operation(summary = "Adiciona um departamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<DepartamentoDTO> adicionarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        return new ResponseEntity<>(service.adicionarDepartamento(departamentoDTO), HttpStatus.CREATED);
    }


    @Operation(summary = "Lista departamento e quantidade de pessoas e tarefas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping
    public ResponseEntity<List<DepartamentoEntity>> adicionarTarefa(@RequestParam(required = false) Long departamentoId) {
        return ResponseEntity.ok(service.listarDepartamentosComQuantidades(departamentoId));
    }
}

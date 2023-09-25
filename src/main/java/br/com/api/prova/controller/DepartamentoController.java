package br.com.api.prova.controller;

import br.com.api.prova.DTO.record.Departamento;
import br.com.api.prova.service.departamentos.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departamentos")
public class DepartamentoController  {

    @Autowired
    DepartamentoService service;

    @Operation(summary = "Adiciona um departamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos - (Bad Request)"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<Departamento> adicionarDepartamento(@RequestBody Departamento departamentoDTO) {
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
    public ResponseEntity<List<Object[]>> adicionarTarefa() {
        return ResponseEntity.ok(service.listarDepartamentosComQuantidades());
    }
}

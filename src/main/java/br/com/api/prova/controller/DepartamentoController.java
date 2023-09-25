package br.com.api.prova.controller;

import br.com.api.prova.DTO.record.Departamento;
import br.com.api.prova.service.departamentos.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departamento")
public class DepartamentoController  {

    @Autowired
    DepartamentoService service;


    @PostMapping
    public ResponseEntity<Departamento> adicionarDepartamento(@RequestBody Departamento departamentoDTO) {
        return new ResponseEntity<>(service.adicionarDepartamento(departamentoDTO), HttpStatus.CREATED);
    }

    //Listar departamento e quantidade de pessoas e tarefas
    @GetMapping
    public ResponseEntity<List<Object[]>> adicionarTarefa() {
        return ResponseEntity.ok(service.listarDepartamentosComQuantidades());
    }
}

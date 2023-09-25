package br.com.api.prova.controller;

import br.com.api.prova.DTO.record.Tarefas;
import br.com.api.prova.db.entity.TarefaEntity;
import br.com.api.prova.service.tarefas.TarefasService;
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


    @PostMapping
    public ResponseEntity<Tarefas> adicionarTarefa(@RequestBody Tarefas tarefasDTO) {
        return new ResponseEntity<>(service.adicionarTarefa(tarefasDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> alterarTarefa(
            @PathVariable("id") long id,
            @RequestBody Tarefas tarefasDTO) {
        return new ResponseEntity<>(service.alterarTarefa(id, tarefasDTO), HttpStatus.OK);
    }

    @PutMapping("/tarefas/finalizar/{id}")
    public ResponseEntity<?> finalizarTarefa(
            @PathVariable("id") long id,
            @RequestBody Tarefas tarefasDTO) {
        service.finalizarTarefa(id, tarefasDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/obter-todos")
    public ResponseEntity<List<TarefaEntity>> obterTodasTarefas() {
        return new ResponseEntity<>(service.getTodasTarefas(), HttpStatus.OK);
    }

    @DeleteMapping( "/{id}")
    public ResponseEntity<?> removerTarefa(
            @PathVariable("id") long id) {
        service.removerTarefa(id);
        return new ResponseEntity<>("Tarefa selecionada foi removida", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping( "/remover-todos")
    public ResponseEntity<?> removerTodasTarefas() {
        service.removerTodasTarefas();
        return new ResponseEntity<>("Todas as tarefas foram removidas", HttpStatus.NO_CONTENT);
    }

    //Listar 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos.
    @GetMapping("/sem-pessoa-alocada")
    public ResponseEntity<List<TarefaEntity>> semPessoaAlocada() {
        List<TarefaEntity> semPessoaAlocada = service.getPessoaNaoAlocada();
        return ResponseEntity.ok(semPessoaAlocada);
    }
}

package br.com.api.prova.controller;

import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.DTO.TarefasDTO;
import br.com.api.prova.db.entity.PessoasEntity;
import br.com.api.prova.db.entity.TarefasEntity;
import br.com.api.prova.service.tarefas.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/gerenciamento/tarefas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TarefasController {

    @Autowired
    TarefasService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Optional<TarefasEntity>> adicionarTarefa(@RequestBody TarefasDTO tarefasDTO) {
        return new ResponseEntity<>(service.adicionarTarefa(tarefasDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Optional<TarefasEntity>> alterarTarefa(
            @PathVariable(name = "id") long id,
            @RequestBody TarefasDTO tarefasDTO) {
        return new ResponseEntity<>(service.alterarTarefa(id, tarefasDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/obter-todos", method = RequestMethod.GET)
    public ResponseEntity<List<TarefasEntity>> obterTodasTarefas() {
        return new ResponseEntity<>(service.getTodasTarefas(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removerTarefa(
            @PathVariable(name = "id") long id) {
        service.removerTarefa(id);
        return new ResponseEntity<>("Tarefa selecionada foi removida", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/remover-todos", method = RequestMethod.DELETE)
    public ResponseEntity<?> removerTodasTarefas() {
        service.removerTodasTarefas();
        return new ResponseEntity<>("Todas as tarefas foram removidas", HttpStatus.NO_CONTENT);
    }



//    //Listar 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos.
//    @RequestMapping(path = "/pendentes", method = RequestMethod.GET)
//    public ResponseExternal<> tarefasPendentes() {
//
//    }
}

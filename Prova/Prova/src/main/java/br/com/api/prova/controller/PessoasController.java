package br.com.api.prova.controller;

import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.db.entity.PessoasEntity;
import br.com.api.prova.service.pessoas.PessoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/gerenciamento/pessoas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PessoasController {

    @Autowired
    PessoasService service;

    @RequestMapping(method = RequestMethod.POST)                       //OK
    public ResponseEntity<Optional<PessoasEntity>> adicionarPessoa(@RequestBody PessoasDTO pessoasDTO) {
        return new ResponseEntity<>(service.adicionarPessoa(pessoasDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)            //OK porém n ta substituindo na ordem
    public ResponseEntity<Optional<PessoasEntity>> alterarPessoa(
            @PathVariable(name = "id") long id,
            @RequestBody PessoasDTO pessoasDTO) {
        return new ResponseEntity<>(service.alterarPessoa(id, pessoasDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/obter-todos", method = RequestMethod.GET)     //OK
    public ResponseEntity<List<PessoasEntity>> obterTodos() {
        return new ResponseEntity<>(service.getTodasPessoas(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)         //OK
    public ResponseEntity<?> removerPessoa(
            @PathVariable(name = "id") long id) {
        service.removerPessoa(id);
        return new ResponseEntity<>("Usuário selecionado foi removido", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/remover-todos", method = RequestMethod.DELETE)    //OK
    public ResponseEntity<?> removerTodos() {
        service.removerTodos();
        return new ResponseEntity<>("Todos foram removidos", HttpStatus.NO_CONTENT);
    }






//    // Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas.
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseExternal<> listarPessoas() {
//        return new ResponseExternal();
//    }
//
//    //Buscar pessoas por nome e período, retorna média de horas gastas por tarefa.
//    @RequestMapping(path = "/gastos", method = RequestMethod.GET)
//    public ResponseExternal<> gastos() {
//        return new ResponseExternal();
//    }
}

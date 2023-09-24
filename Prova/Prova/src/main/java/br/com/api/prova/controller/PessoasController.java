package br.com.api.prova.controller;

import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.db.entity.PessoasEntity;
import br.com.api.prova.external.ResponseExternal;
import br.com.api.prova.service.pessoa.PessoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping(value = "api/gerenciamento/pessoas")
public class PessoasController {


    @Autowired
    PessoasService service;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<PessoasEntity>> adicionarPessoa(@RequestBody PessoasDTO pessoasDTO) {
        //return new ResponseExternal<>(service.adicionaPessoa(pessoasDTO));
        return ResponseEntity.ok(service.adicionaPessoa(pessoasDTO));
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseExternal<PessoasEntity> alterarPessoa(
//            @PathVariable(name = "id") long id,
//            @RequestBody PessoasDTO pessoasDTO) {
//        return ResponseEntity.ok(service.alterarPessoa(id, pessoasDTO));
//    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<?>> removerPessoa(
            @PathVariable(name = "id") long id) {
        service.removerPessoa(id);
        return ResponseEntity.noContent().build();
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

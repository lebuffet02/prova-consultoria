package br.com.api.prova.controller;

import br.com.api.prova.DTO.record.Pessoas;
import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.service.pessoas.PessoasService;
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


    @PostMapping
    public ResponseEntity<Pessoas> adicionarPessoa(@RequestBody Pessoas pessoasDTO) {
        return new ResponseEntity<>(service.adicionarPessoa(pessoasDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> alterarPessoa(@PathVariable("id") long id,
                                                 @RequestBody Pessoas pessoasDTO) {
        service.alterarPessoa(id, pessoasDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/obter-todos")
    public ResponseEntity<List<PessoaEntity>> obterTodos() {
        return new ResponseEntity<>(service.getTodasPessoas(), HttpStatus.OK);
    }

    @DeleteMapping( "/{id}")
    public ResponseEntity<?> removerPessoa(
            @PathVariable("id") long id) {
        service.removerPessoa(id);
        return new ResponseEntity<>("Usuário selecionado foi removido", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping( "/remover-todos")
    public ResponseEntity<?> removerTodos() {
        service.removerTodos();
        return new ResponseEntity<>("Todos foram removidos", HttpStatus.NO_CONTENT);
    }

    // Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas.
    @GetMapping
    public  ResponseEntity<List<Object[]>> listarPessoas() {
        return ResponseEntity.ok(service.findAllByPessoasComTotalHorasGastas());
    }

    //Buscar pessoas por nome e período, retorna média de horas gastas por tarefa.
    @GetMapping("/media-gasto/{nome}")
    public ResponseEntity<List<Object[]>> gastos(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(service.buscarMediaHorasPorTarefaPorNome(nome));
    }
}

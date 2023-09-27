package br.com.api.prova.dto;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
//@JsonPropertyOrder({
//        "idPessoa",
//        "nome",
//        "departamento",
//        "tarefaList"
//})
public class PessoaDTO {

    private Long id;
    private String nome;
    private DepartamentoDTO departamento;
    private List<TarefaDTO> tarefas;

    public PessoaDTO() {}

}
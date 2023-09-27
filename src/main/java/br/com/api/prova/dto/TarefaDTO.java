package br.com.api.prova.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private OffsetDateTime prazo;
    private int tempoDiasDuracao;
    private boolean isFinalizado;
    private DepartamentoDTO departamento;
    private PessoaDTO pessoaAlocada;

    public TarefaDTO() {}
}

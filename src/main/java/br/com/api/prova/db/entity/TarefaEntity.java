package br.com.api.prova.db.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity(name = "TarefaEntity")
@Table(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private OffsetDateTime prazo;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private DepartamentoEntity departamento;
    private LocalTime duracao;
    private Boolean finalizado;

    @ManyToOne
    @JoinColumn(name = "pessoa_id") // Nome da coluna que faz referência à pessoa alocada
    private PessoaEntity pessoaAlocada;
}

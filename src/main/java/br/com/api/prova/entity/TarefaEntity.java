package br.com.api.prova.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity(name = "TarefaEntity")
@Table(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private OffsetDateTime prazo;
    @Column
    private int tempoDiasDuracao;
    @Column
    private boolean finalizado;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    private DepartamentoEntity departamento;

    @ManyToOne   //cada pessoa pertence a uma lista de tarefas
    @JoinColumn(name = "idPessoa")
    private PessoaEntity pessoaAlocada;

}

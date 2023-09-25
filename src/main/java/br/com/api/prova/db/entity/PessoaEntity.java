package br.com.api.prova.db.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "PessoaEntity")
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private DepartamentoEntity departamento;

    @OneToMany(mappedBy = "pessoaAlocada", cascade = CascadeType.ALL)
    private List<TarefaEntity> tarefas;
}

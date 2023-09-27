package br.com.api.prova.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "PessoaEntity")
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "idDepartamento")
    private DepartamentoEntity departamento;

    @OneToMany(mappedBy = "pessoaAlocada", cascade = CascadeType.ALL)
    private List<TarefaEntity> tarefas;

}

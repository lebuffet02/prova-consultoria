package br.com.api.prova.db.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@JsonIgnoreProperties
public class PessoasEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "departamento")
    private String departamento;

    @OneToMany()
    private List<TarefasEntity> tarefas = new ArrayList<>();

}

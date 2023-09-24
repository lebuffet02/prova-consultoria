package br.com.api.prova.db.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
public class TarefasEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "prazo")
    private String prazo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "pessoaAlocada")
    private String pessoaAlocada;

    @Column(name = "finalizado")
    private boolean isFinalizado;
}

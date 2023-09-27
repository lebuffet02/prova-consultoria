package br.com.api.prova.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "DepartamentoEntity")
@Table(name = "departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
}


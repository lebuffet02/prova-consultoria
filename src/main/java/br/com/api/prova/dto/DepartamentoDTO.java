package br.com.api.prova.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoDTO {

    private Long idDepartamento;
    private String titulo;

    public DepartamentoDTO() {}

}

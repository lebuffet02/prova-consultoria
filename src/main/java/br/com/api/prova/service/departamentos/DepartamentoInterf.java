package br.com.api.prova.service.departamentos;

import br.com.api.prova.DTO.record.Departamento;

import java.util.List;

public interface DepartamentoInterf {

    Departamento adicionarDepartamento(Departamento departamentoDTO);

    List<Object[]> listarDepartamentosComQuantidades();
}

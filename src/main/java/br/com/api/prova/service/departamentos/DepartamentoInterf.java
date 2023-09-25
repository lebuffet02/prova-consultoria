package br.com.api.prova.service.departamentos;

import br.com.api.prova.record.Departamento;

import java.util.List;

public interface DepartamentoInterf {

    Departamento adicionarDepartamento(Departamento departamentoDTO);

    List<Object[]> listarDepartamentosComQuantidades();
}

package br.com.api.prova.service.departamentos;

import br.com.api.prova.dto.DepartamentoDTO;
import br.com.api.prova.entity.DepartamentoEntity;

import java.util.List;

public interface DepartamentoInterf {

    DepartamentoDTO adicionarDepartamento(DepartamentoDTO departamentoDTO);

    List<DepartamentoEntity> listarDepartamentosComQuantidades(Long departamentoId);
}

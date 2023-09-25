package br.com.api.prova.util;

import br.com.api.prova.record.Departamento;
import br.com.api.prova.db.entity.DepartamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperUtilsDepartamento {

    MapperUtilsDepartamento MAPPER = Mappers.getMapper(MapperUtilsDepartamento.class);

    Departamento mapToDepartamentoDTO(DepartamentoEntity departamentoEntity);

    DepartamentoEntity mapToDepartamentoEntity(Departamento departamentoDTO);
}

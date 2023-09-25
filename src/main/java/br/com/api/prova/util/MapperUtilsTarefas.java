package br.com.api.prova.util;

import br.com.api.prova.DTO.record.Tarefas;
import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.db.entity.TarefaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperUtilsTarefas {

    MapperUtilsTarefas MAPPER = Mappers.getMapper(MapperUtilsTarefas.class);

    Tarefas mapToTarefasDTO(TarefaEntity tarefaEntity);

    TarefaEntity mapToTarefasEntity(Tarefas tarefasDTO);

    String mapToPessoaAlocada(PessoaEntity pessoaEntity);

}

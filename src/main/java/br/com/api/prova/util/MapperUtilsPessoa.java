package br.com.api.prova.util;

import br.com.api.prova.record.Pessoas;
import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.record.Tarefas;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperUtilsPessoa {

    MapperUtilsPessoa MAPPER = Mappers.getMapper(MapperUtilsPessoa.class);

    Pessoas mapToPessoaDTO(PessoaEntity pessoa);

    PessoaEntity mapToPessoaEntity(Pessoas cadastroPessoa);

}

package br.com.api.prova.util;

import br.com.api.prova.DTO.record.Pessoas;
import br.com.api.prova.db.entity.PessoaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperUtilsPessoa {

    MapperUtilsPessoa MAPPER = Mappers.getMapper(MapperUtilsPessoa.class);

    Pessoas mapToPessoaDTO(PessoaEntity pessoa);

    PessoaEntity mapToPessoaEntity(Pessoas cadastroPessoa);

}

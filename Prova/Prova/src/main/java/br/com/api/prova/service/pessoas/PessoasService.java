package br.com.api.prova.service.pessoas;


import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.db.entity.PessoasEntity;
import br.com.api.prova.db.repository.PessoasRepository;
import br.com.api.prova.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoasService implements PessoasImpl {

    @Autowired
    PessoasRepository repository;

    @Override
    public Optional<PessoasEntity> adicionarPessoa(PessoasDTO pessoasDTO) {
            if (!ObjectUtils.isEmpty(pessoasDTO)) {
                Optional<PessoasEntity> pessoas = Optional.of(MapperUtils.mapperUtils(pessoasDTO, PessoasEntity.class));
                return Optional.of(repository.save(pessoas.get()));
            }
            return Optional.empty();
    }

    @Override
    public Optional<PessoasEntity> alterarPessoa(Long id, PessoasDTO pessoasDTO) {
        if (!ObjectUtils.isEmpty(pessoasDTO) && repository.existsById(id)) {
            PessoasEntity pessoa = MapperUtils.mapperUtils(pessoasDTO, PessoasEntity.class);
            //pessoa.setId(id);
            return Optional.of(repository.save(pessoa));
        }
        return Optional.empty();
    }

    @Override
    public List<PessoasEntity> getTodasPessoas() {
        List<PessoasEntity> pessoasEntityList;
        if(!CollectionUtils.isEmpty(repository.findAll())) {
            pessoasEntityList = repository.findAll().stream().collect(Collectors.toList());
            return pessoasEntityList;
        }
        return new ArrayList<>();
    }

    @Override
    public void removerPessoa(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void removerTodos() {
        repository.deleteAll();
    }
}

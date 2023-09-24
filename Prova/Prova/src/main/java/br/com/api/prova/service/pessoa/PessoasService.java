package br.com.api.prova.service.pessoa;


import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.db.entity.PessoasEntity;
import br.com.api.prova.db.repository.PessoasRepository;
import br.com.api.prova.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoasService implements PessoasImpl {

    @Autowired
    PessoasRepository repository;


    @Override
    public Optional<PessoasEntity> adicionaPessoa(PessoasDTO pessoasDTO) {
        try {
            if (!ObjectUtils.isEmpty(pessoasDTO)) {
                Optional<PessoasEntity> pessoas = Optional.of(MapperUtils.mapperUtils(pessoasDTO, PessoasEntity.class));
                return Optional.of(repository.save(pessoas.get()));
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

//    @Override
//    public Optional<PessoasEntity> alterarPessoa(Long id, PessoasDTO pessoasDTO) {
//        try {
//            if (repository.findById(id).isPresent()) {
//                return Optional.of(repository.findById(id).get());
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    @Override
    public void removerPessoa(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


//    @Override
//    public List<PessoasEntity> getPessoas() {
//        try {
//            return repository.findAll().stream().collect(Collectors.toList());
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }



}

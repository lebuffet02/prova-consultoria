package br.com.api.prova.service.pessoas;


import br.com.api.prova.dto.PessoaDTO;
import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.entity.TarefaEntity;
import br.com.api.prova.exception.pessoasException.EntidadePessoasException;
import br.com.api.prova.exception.pessoasException.PessoasException;
import br.com.api.prova.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoasService implements PessoasInterf {


    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<PessoaEntity> getTodasPessoas() {
        List<PessoaEntity> pessoasEntityList;
        if(!CollectionUtils.isEmpty(pessoaRepository.findAll())) {
            pessoasEntityList = pessoaRepository.findAll().stream().collect(Collectors.toList());
            return pessoasEntityList;
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<PessoaEntity> adicionarPessoa(PessoaDTO pessoaDTO) {
        try {
            Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(pessoaDTO.getId());
            if (ObjectUtils.isEmpty(pessoaDTO) || pessoaEntity.isPresent()) {
                throw new EntidadePessoasException("Não foi possível adicionar a pessoa");
            }
            PessoaEntity pessoa = mapper.map(pessoaDTO, PessoaEntity.class);
            return Optional.of(pessoaRepository.save(pessoa));
        } catch (PessoasException e) {
            throw new PessoasException("Não foi possível alterar a pessoa", e);
        }
    }

    @Override
    public PessoaEntity alterarPessoa(Long id, PessoaEntity pessoa) {
        try {
            Optional<PessoaEntity> optionalPessoa = pessoaRepository.findById(id);
            if (optionalPessoa.isPresent()) {
                PessoaEntity pessoaEntity = optionalPessoa.get();
                pessoaEntity.setNome(pessoa.getNome());
                pessoaEntity.setDepartamento(pessoa.getDepartamento());
                pessoaEntity.getTarefas().clear();
                pessoaEntity.setTarefas(pessoa.getTarefas());
                return pessoaRepository.save(pessoaEntity);
            }
            throw new PessoasException("Não foi possível alterar a pessoa");
        } catch (PessoasException e) {
            throw new PessoasException("Não foi possível alterar a pessoa", e);
        }
    }

    @Override
    public void removerPessoa(Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
        }
    }

    @Override
    public void removerTodos() {
        pessoaRepository.deleteAll();
    }

    @Override
    public List<TarefaEntity> findAllByPessoasComTotalHorasGastas() {
        return pessoaRepository.findAllByPessoasComTotalHorasGastas();
    }

    @Override
    public List<Object[]> buscarMediaHorasPorTarefaPorNome(String nome) {
        return pessoaRepository.buscarMediaHorasPorTarefaPorNome(nome);
    }
}

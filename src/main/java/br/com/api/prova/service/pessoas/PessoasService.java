package br.com.api.prova.service.pessoas;



import br.com.api.prova.DTO.record.Pessoas;
import br.com.api.prova.db.entity.DepartamentoEntity;
import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.db.repository.PessoaRepository;
import br.com.api.prova.exception.departamentoException.DepartamentoException;
import br.com.api.prova.exception.pessoasException.EntidadePessoasException;
import br.com.api.prova.service.departamentos.DepartamentoService;
import br.com.api.prova.util.MapperUtilsPessoa;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoasService implements PessoasInterf {

    private final PessoaRepository repository;
    private final DepartamentoService service;

    @Override
    public Pessoas adicionarPessoa(Pessoas pessoasDTO) {
        Optional<PessoaEntity> departamento = repository.findById(pessoasDTO.id());
        if (departamento.isPresent()) {
            throw new DepartamentoException("Departamento já existe");
        }
        PessoaEntity pessoaEntity = MapperUtilsPessoa.MAPPER.mapToPessoaEntity(pessoasDTO);
        PessoaEntity salvarPessoa = repository.save(pessoaEntity);
        return MapperUtilsPessoa.MAPPER.mapToPessoaDTO(salvarPessoa);
    }


    @Override
    public Pessoas alterarPessoa(Long id, Pessoas pessoasDTO) {
        PessoaEntity pessoa = repository.findById(id)
                .orElseThrow(() -> new EntidadePessoasException("Pessoa não encontrada"));
        if(pessoasDTO != null) {
            pessoa.setId(pessoasDTO.id());
            pessoa.setNome(pessoasDTO.nome());
            if (pessoasDTO.departamento() != null) {
                DepartamentoEntity departamento = service.findByTitulo(pessoasDTO.departamento().titulo());
                pessoa.setDepartamento(departamento);
            }
        }
        PessoaEntity pessoaUpdate = repository.save(pessoa);
        return MapperUtilsPessoa.MAPPER.mapToPessoaDTO(pessoaUpdate);
    }


    @Override
    public List<PessoaEntity> getTodasPessoas() {
        List<PessoaEntity> pessoasEntityList;
        if(!CollectionUtils.isEmpty(repository.findAll())) {
            pessoasEntityList = repository.findAll().stream().collect(Collectors.toList());
            return pessoasEntityList;
        }
        return new ArrayList<>();
    }

    @Override
    public List<Object[]> findAllByPessoasComTotalHorasGastas() {
        return repository.findAllByPessoasComTotalHorasGastas();
    }

    @Override
    public List<Object[]> buscarMediaHorasPorTarefaPorNome(String nome) {
        return repository.buscarMediaHorasPorTarefaPorNome(nome);
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

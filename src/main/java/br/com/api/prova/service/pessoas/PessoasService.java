package br.com.api.prova.service.pessoas;


import br.com.api.prova.record.Pessoas;
import br.com.api.prova.db.entity.DepartamentoEntity;
import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.db.entity.TarefaEntity;
import br.com.api.prova.db.repository.PessoaRepository;
import br.com.api.prova.db.repository.TarefasRepository;
import br.com.api.prova.exception.pessoasException.EntidadePessoasException;
import br.com.api.prova.exception.regraNegocioException.RegraNegocioException;
import br.com.api.prova.exception.tarefasException.TarefasException;
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
    private final TarefasRepository tarefasRepository;
    private DepartamentoService service;


    @Override
    public Pessoas adicionarPessoa(Pessoas pessoasDTO) {
        Optional<PessoaEntity> pessoa = repository.findById(pessoasDTO.id());
        if (pessoa.isPresent()) {
            throw new EntidadePessoasException("falha-buscar.pessoa.nao.encontrada");
        }
        PessoaEntity pessoaEntity = MapperUtilsPessoa.MAPPER.mapToPessoaEntity(pessoasDTO);
        PessoaEntity salvarPessoa = repository.save(pessoaEntity);
        return MapperUtilsPessoa.MAPPER.mapToPessoaDTO(salvarPessoa);
    }


    @Override
    public Pessoas alterarPessoa(Long id, Pessoas pessoasDTO) {
        PessoaEntity pessoa = repository.findById(id)
                .orElseThrow(() -> new EntidadePessoasException("falha-buscar.pessoa.nao.encontrada"));

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
    public void alocarPessoa(Long pessoaId, Long tarefaId) {
        PessoaEntity pessoa = repository.findById(pessoaId)
                .orElseThrow(() -> new EntidadePessoasException("falha-buscar.pessoa.nao.encontrada"));

        TarefaEntity tarefa = tarefasRepository.findById(tarefaId)
                .orElseThrow(() -> new TarefasException("falha-buscar.tarefa.nao.encontrada"));

        if (!pessoa.getDepartamento().equals(tarefa.getDepartamento())) {
            throw new RegraNegocioException("falha-regra-negocio.departamento");
        }
        tarefa.setPessoaAlocada(pessoa);
        tarefasRepository.save(tarefa);
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

    //    @Override
//    public List<Object[]> findAllByPessoasComTotalHorasGastas() {
//        return repository.findAllByPessoasComTotalHorasGastas();
//    }
}

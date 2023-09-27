package br.com.api.prova.service.tarefas;

import br.com.api.prova.dto.DepartamentoDTO;
import br.com.api.prova.dto.PessoaDTO;
import br.com.api.prova.dto.TarefaDTO;
import br.com.api.prova.entity.DepartamentoEntity;
import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.entity.TarefaEntity;
import br.com.api.prova.exception.pessoasException.PessoasException;
import br.com.api.prova.exception.regraNegocioException.RegraNegocioException;
import br.com.api.prova.exception.tarefasException.TarefasException;
import br.com.api.prova.repository.PessoaRepository;
import br.com.api.prova.repository.TarefasRepository;
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
public class TarefasService implements TarefasInterf {

    @Autowired
    TarefasRepository tarefaRepository;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<TarefaEntity> getTodasTarefas() {
        List<TarefaEntity> tarefaEntityList;
        if(!CollectionUtils.isEmpty(tarefaRepository.findAll())) {
            tarefaEntityList = tarefaRepository.findAll().stream().collect(Collectors.toList());
            return tarefaEntityList;
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<TarefaEntity> adicionarTarefa(TarefaDTO tarefaDTO) {
        try {
            if(ObjectUtils.isEmpty(tarefaDTO) || tarefaRepository.findById(tarefaDTO.getId()).isPresent()) {
                throw new TarefasException("Não foi possível adicionar a pessoa");
            }
            TarefaEntity tarefaEntity = mapper.map(tarefaDTO, TarefaEntity.class);
            tarefaEntity.setFinalizado(false);
            return Optional.of(tarefaRepository.save(tarefaEntity));
        } catch (TarefasException e) {
            throw new TarefasException("Não foi possível adicionar a pessoa");
        }
    }

    @Override
    public TarefaEntity alterarTarefa(Long id, TarefaDTO tarefaDTO) {
        try {
            Optional<TarefaEntity> optionalTarefa = tarefaRepository.findById(id);
            if (!ObjectUtils.isEmpty(tarefaDTO) && optionalTarefa.isPresent()) {
                TarefaEntity pessoaEntity = optionalTarefa.get();
                pessoaEntity.setTitulo(tarefaDTO.getTitulo());
                pessoaEntity.setPrazo(tarefaDTO.getPrazo());
                pessoaEntity.setDescricao(tarefaDTO.getDescricao());
                pessoaEntity.setTempoDiasDuracao(tarefaDTO.getTempoDiasDuracao());
                pessoaEntity.setFinalizado(false);
                pessoaEntity.setDepartamento(getConverteParaEntidadeDep(tarefaDTO.getDepartamento()));
                pessoaEntity.setPessoaAlocada(getConverteParaEntidadePessoa(tarefaDTO.getPessoaAlocada()));
                return tarefaRepository.save(pessoaEntity);
            }
            throw new PessoasException("Não foi possível alterar a pessoa");
        } catch (TarefasException e) {
            throw new TarefasException("Não foi possível alterar a tarefa", e);
        }
    }

    @Override
    public void alocarPessoa(Long pessoaId, Long tarefaId) {
        try {
            PessoaEntity pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new TarefasException("Não foi possível localizar a pessoa"));
            TarefaEntity tarefa = tarefaRepository.findById(tarefaId).orElseThrow(() -> new TarefasException("Não foi possível localizar a tarefa"));
            if(!pessoa.getDepartamento().getId().equals(tarefa.getDepartamento().getId())) {
                throw new RegraNegocioException("Não foi possível alocar o indivíduo");
            }
            tarefa.getPessoaAlocada().setId(pessoaId);
            tarefaRepository.save(tarefa);
        } catch (TarefasException e) {
            throw new TarefasException("Não foi possível alocar a pessoa na tarefa", e);
        }
    }

    @Override
    public TarefaEntity finalizarTarefa(Long id, TarefaDTO tarefaDTO) {
        try {
            Optional<TarefaEntity> tarefaOptional = tarefaRepository.findById(id);
            if(!ObjectUtils.isEmpty(tarefaDTO) && tarefaOptional.isPresent()) {
                TarefaEntity tarefa = tarefaOptional.get();
                if(tarefaDTO.isFinalizado()) {
                    tarefa.setFinalizado(tarefa.isFinalizado());
                    return tarefaRepository.save(tarefa);
                }
            }
        } catch (TarefasException e) {
            throw new TarefasException("Não foi possível finalizar a tarefa", e);
        }
        throw new RegraNegocioException("Não foi possível alocar o indivíduo");
    }


    @Override
    public List<TarefaEntity> getPessoaNaoAlocada() {
        return tarefaRepository.findFirst3TarefasSemPessoaAlocada();
    }

    @Override
    public void removerTarefa(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        }
    }

    @Override
    public void removerTodasTarefas() {
        tarefaRepository.deleteAll();
    }

    private DepartamentoEntity getConverteParaEntidadeDep(DepartamentoDTO departamentoDTO) {
        return mapper.map(departamentoDTO, DepartamentoEntity.class);
    }

    private PessoaEntity getConverteParaEntidadePessoa(PessoaDTO departamentoDTO) {
        return mapper.map(departamentoDTO, PessoaEntity.class);
    }
}

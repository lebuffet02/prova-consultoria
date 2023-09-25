package br.com.api.prova.service.tarefas;

import br.com.api.prova.DTO.record.Tarefas;
import br.com.api.prova.db.entity.DepartamentoEntity;
import br.com.api.prova.db.entity.TarefaEntity;
import br.com.api.prova.db.repository.TarefasRepository;
import br.com.api.prova.exception.pessoasException.EntidadePessoasException;
import br.com.api.prova.exception.tarefasException.TarefasException;
import br.com.api.prova.service.departamentos.DepartamentoService;
import br.com.api.prova.util.MapperUtilsTarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService implements TarefasInterf {

    @Autowired
    TarefasRepository repository;
    @Autowired
    DepartamentoService service;

    @Override
    public Tarefas adicionarTarefa(Tarefas tarefasDTO) {
        Optional<TarefaEntity> tarefa = repository.findById(tarefasDTO.id());
        if (tarefa.isPresent()) {
            throw new TarefasException("Tarefa com esse id já existe");
        }
        TarefaEntity tarefaEntity = MapperUtilsTarefas.MAPPER.mapToTarefasEntity(tarefasDTO);
        TarefaEntity salvarTarefa = repository.save(tarefaEntity);
        return MapperUtilsTarefas.MAPPER.mapToTarefasDTO(salvarTarefa);
    }

    @Override
    public Tarefas alterarTarefa(Long id, Tarefas tarefasDTO) {
        TarefaEntity tarefa = repository.findById(id)
                .orElseThrow(() -> new EntidadePessoasException("Tarefa não encontrada"));

        if (tarefasDTO != null) {
            tarefa.setId(tarefasDTO.id());
            tarefa.setTitulo(tarefasDTO.titulo());
            tarefa.setDescricao(tarefasDTO.descricao());
            tarefa.setPrazo(tarefasDTO.prazo());
            if (tarefasDTO.departamento() != null) {
                DepartamentoEntity departamento = service.findByTitulo(tarefasDTO.departamento().titulo());
                tarefa.setDepartamento(departamento);
            }
        }
        TarefaEntity tarefaEntity = repository.save(tarefa);
        return MapperUtilsTarefas.MAPPER.mapToTarefasDTO(tarefaEntity);
    }

    @Override
    public void finalizarTarefa(Long id, Tarefas tarefasDTO) {
        repository.findById(id).orElseThrow(() -> new EntidadePessoasException("Tarefa com id não encontrada"));
        if (tarefasDTO != null && tarefasDTO.isFinalizado()) {
            repository.deleteById(id);
        }
    }

    @Override
    public List<TarefaEntity> getTodasTarefas() {
        List<TarefaEntity> tarefaEntityList;
        if(!CollectionUtils.isEmpty(repository.findAll())) {
            tarefaEntityList = repository.findAll().stream().collect(Collectors.toList());
            return tarefaEntityList;
        }
        return new ArrayList<>();
    }

    @Override
    public List<TarefaEntity> getPessoaNaoAlocada() {
        return repository.findFirst3TarefasSemPessoaAlocada();
    }

    @Override
    public void removerTarefa(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void removerTodasTarefas() {
        repository.deleteAll();
    }
}

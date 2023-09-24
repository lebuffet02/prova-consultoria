package br.com.api.prova.service.tarefas;

import br.com.api.prova.DTO.TarefasDTO;
import br.com.api.prova.db.entity.TarefasEntity;
import br.com.api.prova.db.repository.TarefasRepository;
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
public class TarefasService implements TarefasImpl {

    @Autowired
    TarefasRepository repository;


    @Override
    public Optional<TarefasEntity> adicionarTarefa(TarefasDTO tarefasDTO) {
        if (!ObjectUtils.isEmpty(tarefasDTO)) {
            Optional<TarefasEntity> tarefas = Optional.of(MapperUtils.mapperUtils(tarefasDTO, TarefasEntity.class));
            return Optional.of(repository.save(tarefas.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TarefasEntity> alterarTarefa(Long id, TarefasDTO tarefasDTO) {
        if (!ObjectUtils.isEmpty(tarefasDTO) && repository.existsById(id)) {
            TarefasEntity pessoa = MapperUtils.mapperUtils(tarefasDTO, TarefasEntity.class);
            //pessoa.setId(id);
            return Optional.of(repository.save(pessoa));
        }
        return Optional.empty();
    }

    @Override
    public List<TarefasEntity> getTodasTarefas() {
        List<TarefasEntity> tarefasEntityList;
        if(!CollectionUtils.isEmpty(repository.findAll())) {
            tarefasEntityList = repository.findAll().stream().collect(Collectors.toList());
            return tarefasEntityList;
        }
        return new ArrayList<>();
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

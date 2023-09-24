package br.com.api.prova.service.tarefas;

import br.com.api.prova.DTO.TarefasDTO;
import br.com.api.prova.db.entity.TarefasEntity;

import java.util.List;
import java.util.Optional;

public interface TarefasImpl {

//    Optional<TarefasEntity> adicionarTarefa(TarefasDTO tarefasDTO);
//
//    Optional<TarefasEntity> alterarTarefa(Long id, TarefasDTO tarefasDTO);
//
//    List<TarefasEntity> getTodasTarefas();

    Optional<TarefasEntity> adicionarTarefa(TarefasDTO tarefasDTO);

    Optional<TarefasEntity> alterarTarefa(Long id, TarefasDTO tarefasDTO);

    List<TarefasEntity> getTodasTarefas();

    void removerTarefa(Long id);

    void removerTodasTarefas();
}

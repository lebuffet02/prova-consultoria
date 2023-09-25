package br.com.api.prova.service.tarefas;

import br.com.api.prova.DTO.record.Tarefas;
import br.com.api.prova.db.entity.TarefaEntity;

import java.util.List;
import java.util.Optional;

public interface TarefasInterf {

    Tarefas adicionarTarefa(Tarefas tarefasDTO);

    Tarefas alterarTarefa(Long id, Tarefas tarefasDTO);

    void finalizarTarefa(Long id, Tarefas tarefasDTO);

    List<TarefaEntity> getTodasTarefas();

    List<TarefaEntity> getPessoaNaoAlocada();

    void removerTarefa(Long id);

    void removerTodasTarefas();
}

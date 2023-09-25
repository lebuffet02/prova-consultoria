package br.com.api.prova.service.tarefas;

import br.com.api.prova.record.Tarefas;
import br.com.api.prova.db.entity.TarefaEntity;

import java.util.List;

public interface TarefasInterf {

    Tarefas adicionarTarefa(Tarefas tarefasDTO);

    Tarefas alterarTarefa(Long id, Tarefas tarefasDTO);

    void finalizarTarefa(Long id, Tarefas tarefasDTO);

    List<TarefaEntity> getTodasTarefas();

    List<TarefaEntity> getPessoaNaoAlocada();

    void removerTarefa(Long id);

    void removerTodasTarefas();
}

package br.com.api.prova.service.tarefas;

import br.com.api.prova.dto.TarefaDTO;
import br.com.api.prova.entity.TarefaEntity;

import java.util.List;
import java.util.Optional;

public interface TarefasInterf {

    Optional<TarefaEntity> adicionarTarefa(TarefaDTO tarefaDTO);

    TarefaEntity alterarTarefa(Long id, TarefaDTO tarefaDTO);

    void alocarPessoa(Long pessoaId, Long tarefaId);

    TarefaEntity finalizarTarefa(Long id, TarefaDTO tarefaDTO);

    List<TarefaEntity> getTodasTarefas();

    List<TarefaEntity> getPessoaNaoAlocada();

    void removerTarefa(Long id);

    void removerTodasTarefas();
}

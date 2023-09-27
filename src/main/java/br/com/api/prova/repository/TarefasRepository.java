package br.com.api.prova.repository;

import br.com.api.prova.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TarefasRepository extends JpaRepository<TarefaEntity, Long> {

    //"Lista 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos"

    @Query("SELECT t FROM TarefaEntity t WHERE t.pessoaAlocada is NULL")
    List<TarefaEntity> findFirst3TarefasSemPessoaAlocada();
}

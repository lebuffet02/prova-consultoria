package br.com.api.prova.db.repository;

import br.com.api.prova.db.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TarefasRepository extends JpaRepository<TarefaEntity, Long> {

    @Query("SELECT t FROM TarefaEntity t WHERE t.pessoaAlocada is NULL")
    List<TarefaEntity> findFirst3TarefasSemPessoaAlocada();
}

package br.com.api.prova.db.repository;

import br.com.api.prova.db.entity.TarefasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TarefasRepository extends JpaRepository<TarefasEntity, Long> {
}

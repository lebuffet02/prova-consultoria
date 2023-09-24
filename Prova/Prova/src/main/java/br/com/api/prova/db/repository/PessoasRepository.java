package br.com.api.prova.db.repository;

import br.com.api.prova.db.entity.PessoasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PessoasRepository extends JpaRepository<PessoasEntity, Long> {
}

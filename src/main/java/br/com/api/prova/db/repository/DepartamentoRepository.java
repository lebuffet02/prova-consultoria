package br.com.api.prova.db.repository;

import br.com.api.prova.db.entity.DepartamentoEntity;
import br.com.api.prova.db.entity.TarefaEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {


    DepartamentoEntity findByTitulo(String titulo);


    @Query("SELECT COUNT(p), COUNT(t) " +
            "FROM PessoaEntity p " +
            "LEFT JOIN TarefaEntity t ON p.departamento = t.departamento " +
            "WHERE p.departamento.id = :departamentoId")
    List<Object[]> listarDepartamentosComQuantidades();
}


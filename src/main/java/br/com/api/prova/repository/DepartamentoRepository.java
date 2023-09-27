package br.com.api.prova.repository;

import br.com.api.prova.entity.DepartamentoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {

    @Query(value = "SELECT d.id AS departamento_id, COUNT(t.id) AS quantidade_tarefas " +
            "FROM pessoas p " +
            "LEFT JOIN tarefas t ON p.id = t.id_pessoa_alocada " +
            "LEFT JOIN departamentos d ON p.id_departamento = d.id " +
            "WHERE d.id = :departamentoId " +
            "GROUP BY d.id", nativeQuery = true)
    List<DepartamentoEntity> listarDepartamentosComQuantidades(@Param("departamentoId") Long departamentoId);

}





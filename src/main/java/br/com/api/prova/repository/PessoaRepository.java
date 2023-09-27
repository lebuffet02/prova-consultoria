package br.com.api.prova.repository;

import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {


    @Query(value = "SELECT p.nome, d.titulo, " +
            "CONCAT(FLOOR(SUM(IFNULL(TIME_TO_SEC(t.duracao), 0))/3600), 'h ', " +
            "MOD(SUM(IFNULL(TIME_TO_SEC(t.duracao), 0))/60, 60), 'm') " +
            "FROM pessoas p " +
            "LEFT JOIN tarefas t ON p.id = t.id_pessoa_alocada " +
            "LEFT JOIN departamentos d ON p.id_departamento = d.id " +
            "GROUP BY p.nome, d.titulo", nativeQuery = true)
    List<TarefaEntity> findAllByPessoasComTotalHorasGastas();


    @Query("SELECT p.nome, AVG(COALESCE(t.tempoDiasDuracao, 0) / 3600.0) " +
            "FROM PessoaEntity p " +
            "LEFT JOIN p.tarefas t " +
            "WHERE p.nome = :nome " +
            "GROUP BY p.nome")
    List<Object[]> buscarMediaHorasPorTarefaPorNome(String nome);
}

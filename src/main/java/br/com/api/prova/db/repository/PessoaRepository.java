package br.com.api.prova.db.repository;

import br.com.api.prova.db.entity.PessoaEntity;
import br.com.api.prova.db.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {



//    @Query("SELECT p.nome, p.departamento.titulo, " +
//            "CONCAT(FLOOR(SUM(TIME_TO_SEC(COALESCE(t.duracao, '00:00:00')))/3600), 'h ', " +
//            "MOD(SUM(TIME_TO_SEC(COALESCE(t.duracao, '00:00:00')))/60, 60), 'm') " +
//            "FROM PessoaEntity p " +
//            "LEFT JOIN TarefaEntity t ON p.id = t.pessoaAlocada.id " +
//            "GROUP BY p.nome, p.departamento.titulo")
//    List<Object[]> findAllByPessoasComTotalHorasGastas();


    @Query("SELECT p.nome, AVG(COALESCE(t.tempoDiasDuracao, 0) / 3600.0) " +
            "FROM PessoaEntity p " +
            "LEFT JOIN p.tarefas t " +
            "WHERE p.nome = :nome " +
            "GROUP BY p.nome")
    List<Object[]> buscarMediaHorasPorTarefaPorNome(String nome);
}

package br.com.api.prova.service.pessoas;


import br.com.api.prova.DTO.record.Pessoas;
import br.com.api.prova.db.entity.PessoaEntity;
import java.util.List;

public interface PessoasInterf {


   Pessoas adicionarPessoa(Pessoas pessoasDTO);

   Pessoas alterarPessoa(Long id, Pessoas pessoasDTO);

   List<PessoaEntity> getTodasPessoas();

   void alocarPessoa(Long pessoaId, Long tarefaId);

   List<Object[]> findAllByPessoasComTotalHorasGastas();

   List<Object[]> buscarMediaHorasPorTarefaPorNome(String nome);

   void removerPessoa(Long id);

   void removerTodos();







}

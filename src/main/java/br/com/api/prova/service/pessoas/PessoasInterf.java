package br.com.api.prova.service.pessoas;


import br.com.api.prova.dto.PessoaDTO;
import br.com.api.prova.entity.PessoaEntity;
import br.com.api.prova.entity.TarefaEntity;
import java.util.List;
import java.util.Optional;

public interface PessoasInterf {

   List<PessoaEntity> getTodasPessoas();

   Optional<PessoaEntity> adicionarPessoa(PessoaDTO pessoaDTO);

   PessoaEntity alterarPessoa(Long id, PessoaEntity pessoa);

   void removerPessoa(Long id);

   void removerTodos();

   List<TarefaEntity> findAllByPessoasComTotalHorasGastas();

  List<Object[]> buscarMediaHorasPorTarefaPorNome(String nome);

}

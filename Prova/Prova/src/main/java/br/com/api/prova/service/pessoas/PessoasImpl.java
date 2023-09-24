package br.com.api.prova.service.pessoas;


import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.db.entity.PessoasEntity;

import java.util.List;
import java.util.Optional;

public interface PessoasImpl {


   Optional<PessoasEntity> adicionarPessoa(PessoasDTO pessoasDTO);

   Optional<PessoasEntity> alterarPessoa(Long id, PessoasDTO pessoasDTO);

   List<PessoasEntity> getTodasPessoas();

   void removerPessoa(Long id);

   void removerTodos();







}

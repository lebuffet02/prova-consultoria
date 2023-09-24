package br.com.api.prova.service.pessoa;


import br.com.api.prova.DTO.PessoasDTO;
import br.com.api.prova.db.entity.PessoasEntity;

import java.util.List;
import java.util.Optional;

public interface PessoasImpl {


   Optional<PessoasEntity> adicionaPessoa(PessoasDTO pessoasDTO);

   //Optional<PessoasEntity> alterarPessoa(Long id);

   void removerPessoa(Long id);





}

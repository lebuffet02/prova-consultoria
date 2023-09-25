package br.com.api.prova.record;


import java.time.OffsetDateTime;

public record Tarefas(Long id, String titulo, String descricao, OffsetDateTime prazo, boolean isAtrasado
    , Departamento departamento, Pessoas pessoaAlocada, boolean isFinalizado, int tempoDiasDuracao) {
}

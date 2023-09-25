package br.com.api.prova.DTO.record;


import java.time.OffsetDateTime;

public record Tarefas(Long id, String titulo, String descricao, OffsetDateTime prazo, boolean isAtrasado
    , Departamento departamento, Pessoas pessoaAlocada, boolean isFinalizado) {
}

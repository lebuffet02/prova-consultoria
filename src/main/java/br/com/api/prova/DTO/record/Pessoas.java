package br.com.api.prova.DTO.record;

import java.util.List;

public record Pessoas(Long id, String nome, Departamento departamento, List<Tarefas> tarefasList) {
}


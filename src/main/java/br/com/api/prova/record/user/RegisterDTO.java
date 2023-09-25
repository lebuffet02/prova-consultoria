package br.com.api.prova.record.user;

public record RegisterDTO(String login, String password, UserRole role) {
}

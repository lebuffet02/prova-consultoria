package br.com.api.prova.dto.user;

public record RegisterDTO(String login, String password, UserRole role) {
}

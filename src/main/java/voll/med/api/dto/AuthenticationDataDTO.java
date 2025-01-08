package voll.med.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDataDTO(
        @NotBlank
        String login,
        @NotBlank
        String password) { }
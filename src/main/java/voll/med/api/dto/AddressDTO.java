package voll.med.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @Pattern(regexp = "\\d{8}")
        String postalCode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String number,
        String complement) {
}
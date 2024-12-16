package voll.med.api.dto.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import voll.med.api.dto.address.AddressDTO;

public record PatientDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @Valid
        @NotNull
        AddressDTO addressDTO) {
}

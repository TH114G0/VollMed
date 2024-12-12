package voll.med.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import voll.med.api.entiy.Specialty;

public record DoctorDTO(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        String phoneNumber,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        Specialty specialty,
        @Valid
        AddressDTO addressDTO) {
}
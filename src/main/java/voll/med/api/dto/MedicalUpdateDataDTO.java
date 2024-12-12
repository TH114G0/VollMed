package voll.med.api.dto;

public record MedicalUpdateDataDTO(
        Long id,
        String name,
        String phoneNumber,
        AddressDTO addressDTO) {
}
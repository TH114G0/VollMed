package voll.med.api.dto.doctor;

import voll.med.api.dto.address.AddressDTO;

public record MedicalUpdateDataDTO(
        Long id,
        String name,
        String phoneNumber,
        AddressDTO addressDTO) {
}
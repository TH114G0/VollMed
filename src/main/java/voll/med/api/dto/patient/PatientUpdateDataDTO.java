package voll.med.api.dto.patient;

import voll.med.api.dto.address.AddressDTO;

public record PatientUpdateDataDTO(
        Long id,
        String name,
        AddressDTO addressDTO) {
}

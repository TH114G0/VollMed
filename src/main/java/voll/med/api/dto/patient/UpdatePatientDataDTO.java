package voll.med.api.dto.patient;

import voll.med.api.domain.address.Address;
import voll.med.api.domain.patient.PatientEntity;

public record UpdatePatientDataDTO(

        Long id,
        String name,
        String email,
        String cpf,
        Address address

) {
    public UpdatePatientDataDTO(PatientEntity patientEntity) {
        this(patientEntity.getId(), patientEntity.getName(), patientEntity.getEmail(), patientEntity.getCpf(), patientEntity.getAddress());
    }
}

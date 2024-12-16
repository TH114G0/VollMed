package voll.med.api.dto.patient;

public record PatientListDataDTO(
        String name,
        String email,
        String cpf) {

    public PatientListDataDTO(PatientListDataDTO patientListDataDTO) {
        this(patientListDataDTO.name(), patientListDataDTO.email(), patientListDataDTO.cpf());
    }
}

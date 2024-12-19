package voll.med.api.dto.doctor;


import voll.med.api.domain.address.Address;
import voll.med.api.domain.doctor.DoctorEntity;
import voll.med.api.domain.doctor.Specialty;

public record UpdateDoctorDataDTO(Long id, String name, String email, String crm, String phoneNumber, Specialty specialty, Address address) {

    public UpdateDoctorDataDTO(DoctorEntity doctorEntity) {
        this(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getEmail(), doctorEntity.getCrm(), doctorEntity.getPhoneNumber(), doctorEntity.getSpecialty(), doctorEntity.getAddress());
    }
}

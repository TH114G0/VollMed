package voll.med.api.dto.doctor;

import voll.med.api.entiy.doctor.Specialty;

public record DoctorListDataDTO(String name, String email, String phoneNumber, Specialty specialty) {
    public DoctorListDataDTO(DoctorListDataDTO doctorListDataDTO) {
        this(doctorListDataDTO.name(), doctorListDataDTO.email(), doctorListDataDTO.phoneNumber(), doctorListDataDTO.specialty);
    }
}
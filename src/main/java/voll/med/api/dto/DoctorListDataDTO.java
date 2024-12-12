package voll.med.api.dto;

import voll.med.api.entiy.Specialty;

public record DoctorListDataDTO(String name, String email, String phoneNumber, Specialty specialty) {
    public DoctorListDataDTO(DoctorListDataDTO doctorListDataDTO) {
        this(doctorListDataDTO.name(), doctorListDataDTO.email(), doctorListDataDTO.phoneNumber(), doctorListDataDTO.specialty);
    }
}
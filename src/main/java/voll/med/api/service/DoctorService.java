package voll.med.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voll.med.api.domain.doctor.DoctorEntity;
import voll.med.api.dto.doctor.DoctorDTO;
import voll.med.api.dto.doctor.DoctorListDataDTO;
import voll.med.api.dto.doctor.MedicalUpdateDataDTO;
import voll.med.api.dto.doctor.UpdateDoctorDataDTO;
import voll.med.api.exception.DoctorNotFoundException;
import voll.med.api.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public DoctorEntity create(DoctorDTO doctorDTO) {
        return doctorRepository.save(new DoctorEntity(doctorDTO));
    }

    public Page<DoctorListDataDTO> list(Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable);
    }

    @Transactional
    public UpdateDoctorDataDTO update(MedicalUpdateDataDTO medicalUpdateDataDTO) {
        var doctorEntity = doctorRepository.findById(medicalUpdateDataDTO.id())
                .orElseThrow(() -> new DoctorNotFoundException("ID - " + medicalUpdateDataDTO.id() + " não encontrado"));
        doctorEntity.update(medicalUpdateDataDTO);
        return new UpdateDoctorDataDTO(doctorEntity);
    }

    @Transactional
    public void delete(Long id) {
        var doctorEntity = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("ID - " + id + " não encontrado"));
        doctorEntity.delete();
    }

    public UpdateDoctorDataDTO details(Long id) {
        var doctorEntity = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("ID - " + id + " não encontrado"));
        return new UpdateDoctorDataDTO(doctorEntity);
    }
}
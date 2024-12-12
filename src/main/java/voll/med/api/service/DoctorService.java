package voll.med.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voll.med.api.dto.DoctorDTO;
import voll.med.api.dto.DoctorListDataDTO;
import voll.med.api.dto.MedicalUpdateDataDTO;
import voll.med.api.entiy.DoctorEntity;
import voll.med.api.repository.DoctorRepository;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void create(DoctorDTO doctorDTO) {
        doctorRepository.save(new DoctorEntity(doctorDTO));
    }

    public Page<DoctorListDataDTO> list(Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable);
    }

    @Transactional
    public void update(MedicalUpdateDataDTO medicalUpdateDataDTO) {
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(medicalUpdateDataDTO.id());

        if (doctorEntity.isPresent()) {
            DoctorEntity doctor = doctorEntity.get();
            doctor.update(medicalUpdateDataDTO);
        }
    }

    @Transactional
    public void delete(Long id) {
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(id);

        if (doctorEntity.isPresent()) {
            DoctorEntity doctor = doctorEntity.get();
            doctor.delete();
        }
    }
}
package voll.med.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voll.med.api.dto.patient.PatientDTO;
import voll.med.api.dto.patient.PatientListDataDTO;
import voll.med.api.dto.patient.PatientUpdateDataDTO;
import voll.med.api.entiy.patient.PatientEntity;
import voll.med.api.repository.PatientRepository;

import java.util.Optional;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void create(PatientDTO patientDTO) {
        patientRepository.save(new PatientEntity(patientDTO));
    }

    public Page<PatientListDataDTO> list(Pageable pageable) {
        return patientRepository.findAllByActiveTrue(pageable);
    }

    @Transactional
    public void update(PatientUpdateDataDTO patientUpdateDataDTO) {
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(patientUpdateDataDTO.id());

        if(optionalPatientEntity.isPresent()) {
            PatientEntity patientEntity = optionalPatientEntity.get();
            patientEntity.update(patientUpdateDataDTO);
        }
    }

    @Transactional
    public void delete(Long id) {
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(id);

        if(optionalPatientEntity.isPresent()) {
            PatientEntity patientEntity = optionalPatientEntity.get();
            patientEntity.delete();
        }else {
            throw new RuntimeException("ID - " + id + ", não encontrado.");
        }
    }
}

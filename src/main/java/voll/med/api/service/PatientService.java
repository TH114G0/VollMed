package voll.med.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import voll.med.api.domain.patient.PatientEntity;
import voll.med.api.dto.patient.PatientDTO;
import voll.med.api.dto.patient.PatientListDataDTO;
import voll.med.api.dto.patient.PatientUpdateDataDTO;
import voll.med.api.dto.patient.UpdatePatientDataDTO;
import voll.med.api.exception.PatientNotFoundException;
import voll.med.api.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientEntity create(PatientDTO patientDTO) {
        return patientRepository.save(new PatientEntity(patientDTO));
    }

    public Page<PatientListDataDTO> list(Pageable pageable) {
        return patientRepository.findAllByActiveTrue(pageable);
    }

    @Transactional
    public UpdatePatientDataDTO update(PatientUpdateDataDTO patientUpdateDataDTO) {
        var patientEntity = patientRepository.findById(patientUpdateDataDTO.id())
                .orElseThrow(() -> new PatientNotFoundException("ID - " + patientUpdateDataDTO.id() + " não encontrado"));
        patientEntity.update(patientUpdateDataDTO);
        return new UpdatePatientDataDTO(patientEntity);
    }

    @Transactional
    public void delete(Long id) {
        var patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("ID - " + id + " não encontrado"));
        patientEntity.delete();
    }

    public UpdatePatientDataDTO details(Long id) {
        var patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("ID - " + id + " não encontrado"));
        return new UpdatePatientDataDTO(patientEntity);
    }
}

package voll.med.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import voll.med.api.dto.patient.PatientListDataDTO;
import voll.med.api.domain.patient.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Page<PatientListDataDTO> findAllByActiveTrue(Pageable pageable);
}
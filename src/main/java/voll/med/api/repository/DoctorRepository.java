package voll.med.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import voll.med.api.dto.doctor.DoctorListDataDTO;
import voll.med.api.entiy.doctor.DoctorEntity;



public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    Page<DoctorListDataDTO> findAllByActiveTrue(Pageable pageable);
}
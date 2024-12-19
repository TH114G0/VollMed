package voll.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import voll.med.api.dto.doctor.DoctorDTO;
import voll.med.api.dto.doctor.DoctorListDataDTO;
import voll.med.api.dto.doctor.MedicalUpdateDataDTO;
import voll.med.api.service.DoctorService;
import voll.med.api.dto.doctor.UpdateDoctorDataDTO;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<UpdateDoctorDataDTO> create(@RequestBody @Valid DoctorDTO doctorDTO, UriComponentsBuilder uriComponentsBuilder) {
        var doctor = doctorService.create(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UpdateDoctorDataDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListDataDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = doctorService.list(pageable).map(DoctorListDataDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity<UpdateDoctorDataDTO> update(@RequestBody MedicalUpdateDataDTO medicalUpdateDataDTO) {
        var doctor = doctorService.update(medicalUpdateDataDTO);
        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateDoctorDataDTO> details(@PathVariable Long id) {
        var doctor = doctorService.details(id);
        return ResponseEntity.ok(doctor);
    }
}
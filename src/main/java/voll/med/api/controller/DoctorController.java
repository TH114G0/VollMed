package voll.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import voll.med.api.dto.doctor.DoctorDTO;
import voll.med.api.dto.doctor.DoctorListDataDTO;
import voll.med.api.dto.doctor.MedicalUpdateDataDTO;
import voll.med.api.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public void create(@RequestBody @Valid DoctorDTO doctorDTO) {
        doctorService.create(doctorDTO);
    }

    @GetMapping
    public Page<DoctorListDataDTO> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return doctorService.list(pageable).map(DoctorListDataDTO::new);
    }

    @PutMapping
    public void update(@RequestBody MedicalUpdateDataDTO medicalUpdateDataDTO) {
        doctorService.update(medicalUpdateDataDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        doctorService.delete(id);
    }
}
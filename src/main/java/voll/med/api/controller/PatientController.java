package voll.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import voll.med.api.dto.patient.PatientListDataDTO;
import voll.med.api.dto.patient.PatientDTO;
import voll.med.api.dto.patient.PatientUpdateDataDTO;
import voll.med.api.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public void create(@RequestBody @Valid PatientDTO patientDTO) {
        patientService.create(patientDTO);
    }

    @GetMapping
    public Page<PatientListDataDTO> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return patientService.list(pageable).map(PatientListDataDTO::new);
    }

    @PutMapping
    public void update(@RequestBody PatientUpdateDataDTO patientUpdateDataDTO) {
        patientService.update(patientUpdateDataDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }
}

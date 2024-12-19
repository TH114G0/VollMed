package voll.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voll.med.api.dto.patient.PatientDTO;
import voll.med.api.dto.patient.PatientListDataDTO;
import voll.med.api.dto.patient.PatientUpdateDataDTO;
import voll.med.api.dto.patient.UpdatePatientDataDTO;
import voll.med.api.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<UpdatePatientDataDTO> create(@RequestBody @Valid PatientDTO patientDTO) {
        var patient = patientService.create(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UpdatePatientDataDTO(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListDataDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = patientService.list(pageable).map(PatientListDataDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity<UpdatePatientDataDTO> update(@RequestBody PatientUpdateDataDTO patientUpdateDataDTO) {
        var patient = patientService.update(patientUpdateDataDTO);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdatePatientDataDTO> details(@PathVariable Long id) {
        var patient = patientService.details(id);
        return ResponseEntity.ok(patient);
    }
}

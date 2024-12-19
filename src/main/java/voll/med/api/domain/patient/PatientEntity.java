package voll.med.api.domain.patient;

import jakarta.persistence.*;
import lombok.*;
import voll.med.api.dto.patient.PatientDTO;
import voll.med.api.dto.patient.PatientUpdateDataDTO;
import voll.med.api.domain.address.Address;

import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String cpf;

    @Embedded
    private Address address;

    private Boolean active;

    private LocalDateTime deleteAt;

    public PatientEntity(PatientDTO patientDTO) {
        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.cpf = patientDTO.cpf();
        this.address = new Address(patientDTO.addressDTO());
        this.active = true;
    }

    public void update(PatientUpdateDataDTO patientUpdateDataDTO) {
        if(patientUpdateDataDTO.name() != null) {
            this.name = patientUpdateDataDTO.name();
        }

        if(patientUpdateDataDTO.addressDTO() != null) {
            this.address.update(patientUpdateDataDTO.addressDTO());
        }
    }

    public void delete() {
        this.active = false;
        this.deleteAt = LocalDateTime.now();
    }
}

package voll.med.api.entiy;

import jakarta.persistence.*;
import lombok.*;
import voll.med.api.dto.DoctorDTO;
import voll.med.api.dto.MedicalUpdateDataDTO;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String crm;

    private Boolean active;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public DoctorEntity(DoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.phoneNumber = doctorDTO.phoneNumber();
        this.crm = doctorDTO.crm();
        this.active = true;
        this.specialty = doctorDTO.specialty();
        this.address = new Address(doctorDTO.addressDTO());
    }

    public void update(MedicalUpdateDataDTO medicalUpdateDataDTO) {
        if (medicalUpdateDataDTO.name() != null) {
            this.name = medicalUpdateDataDTO.name();
        }
        if (medicalUpdateDataDTO.phoneNumber() != null) {
            this.phoneNumber = medicalUpdateDataDTO.phoneNumber();
        }
        if (medicalUpdateDataDTO.addressDTO() != null) {
            this.address.update(medicalUpdateDataDTO.addressDTO());
        }
    }

    public void delete() {
        this.active = false;
    }
}
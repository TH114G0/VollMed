package voll.med.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import voll.med.api.dto.address.AddressDTO;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String street;

    private String neighborhood;

    private String postalCode;

    private String city;

    private String state;

    private String number;

    private String complement;

    public Address(AddressDTO addressDTO) {
        if (addressDTO.street() != null) {
            this.street = addressDTO.street();
        }
        if (addressDTO.neighborhood() != null) {
            this.neighborhood = addressDTO.neighborhood();
        }
        if (addressDTO.postalCode() != null) {
            this.postalCode = addressDTO.postalCode();
        }
        if (addressDTO.city() != null) {
            this.city = addressDTO.city();
        }
        if (addressDTO.state() != null) {
            this.state = addressDTO.state();
        }
        if (addressDTO.number() != null) {
            this.number = addressDTO.number();
        }
        if (addressDTO.complement() != null) {
            this.complement = addressDTO.complement();
        }
    }

    public void update(AddressDTO addressDTO) {
        if (addressDTO.street() != null) {
            this.street = addressDTO.street();
        }
        if (addressDTO.neighborhood() != null) {
            this.neighborhood = addressDTO.neighborhood();
        }
        if (addressDTO.postalCode() != null) {
            this.postalCode = addressDTO.postalCode();
        }
        if (addressDTO.city() != null) {
            this.city = addressDTO.city();
        }
        if (addressDTO.state() != null) {
            this.state = addressDTO.state();
        }
        if (addressDTO.number() != null) {
            this.number = addressDTO.number();
        }
        if (addressDTO.complement() != null) {
            this.complement = addressDTO.complement();
        }
    }
}
package com.vollmed.project.entities;

import com.vollmed.project.entities.records.RequestAddress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String postalCode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address(RequestAddress dataAddress) {
        this.street = dataAddress.street();
        this.neighborhood = dataAddress.neighborhood();
        this.postalCode = dataAddress.postalCode();
        this.number = dataAddress.number();
        this.complement = dataAddress.complement();
        this.city = dataAddress.city();
        this.state = dataAddress.state();
    }


    public void updateAddress(RequestAddress dataAddress) {

        if (dataAddress.street() != null) {
            this.street = dataAddress.street();
        }

        if (dataAddress.neighborhood() != null) {
            this.neighborhood = dataAddress.neighborhood();
        }

        if (dataAddress.postalCode() != null) {
            this.postalCode = dataAddress.postalCode();
        }

        if (dataAddress.number() != null) {
            this.number = dataAddress.number();
        }

        if (dataAddress.complement() != null) {
            this.complement = dataAddress.complement();
        }

        if (dataAddress.city() != null) {
            this.city = dataAddress.city();
        }

        if (dataAddress.state() != null) {
            this.state = dataAddress.state();
        }



    }
}

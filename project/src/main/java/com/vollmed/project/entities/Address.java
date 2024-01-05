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


}

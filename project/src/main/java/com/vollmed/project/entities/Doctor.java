package com.vollmed.project.entities;

import com.vollmed.project.entities.enums.Specialty;
import com.vollmed.project.entities.records.RequestDoctor;
import com.vollmed.project.entities.records.RequestUpdateDoctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Doctor")
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    @Column(name = "active", columnDefinition = "boolean")
    private boolean active;


    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;


    public Doctor(RequestDoctor dataDoctor) {
        this.active = true;
        this.name = dataDoctor.name();
        this.email = dataDoctor.email();
        this.crm = dataDoctor.crm();
        this.phone = dataDoctor.phone();
        this.address = dataDoctor.address();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void updateData(RequestUpdateDoctor data) {
        if (data.name()!=null){
            this.name = data.name();

        }
        if (data.phone()!=null){
            this.phone = data.phone();

        }

        if (data.address() !=null){
            this.address.updateAddress(data.address());

        }
    }

    public void status() {
        this.active = false;
    }
}
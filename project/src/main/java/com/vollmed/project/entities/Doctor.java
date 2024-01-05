package com.vollmed.project.entities;

import com.vollmed.project.entities.enums.Specialty;
import com.vollmed.project.entities.records.RequestDoctor;
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

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;


    public Doctor(RequestDoctor dataDoctor) {
        this.name = dataDoctor.name();
        this.email = dataDoctor.email();
        this.crm = dataDoctor.crm();
        this.phone = dataDoctor.phone();
        this.address = dataDoctor.address();
    }
}
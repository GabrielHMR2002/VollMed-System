package com.vollmed.project.entities.records;

import com.vollmed.project.entities.Doctor;
import com.vollmed.project.entities.enums.Specialty;


public record RequestDataDoctor(
        Long id,

        String name,
        String email,
        String crm,
        Specialty specialty) {

    public RequestDataDoctor(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());


    }
}

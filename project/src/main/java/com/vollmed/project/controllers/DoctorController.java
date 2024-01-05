package com.vollmed.project.controllers;

import com.vollmed.project.entities.Doctor;
import com.vollmed.project.entities.records.RequestDoctor;
import com.vollmed.project.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional // transação ativa com o banco de dados pois é um insert/ método de escrita
    public void registerDoctor(@RequestBody @Valid RequestDoctor dataDoctor){
        doctorRepository.save(new Doctor(dataDoctor));
    }


}

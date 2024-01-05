package com.vollmed.project.controllers;

import com.vollmed.project.entities.Doctor;
import com.vollmed.project.entities.records.RequestDataDoctor;
import com.vollmed.project.entities.records.RequestDoctor;
import com.vollmed.project.entities.records.RequestUpdateDoctor;
import com.vollmed.project.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<RequestDataDoctor> findAll(){

        return doctorRepository.findAll().stream().map(RequestDataDoctor::new).toList();
    }

    @PutMapping
    @Transactional
    public void updateData(@RequestBody @Valid RequestUpdateDoctor data){
        var Doctor = doctorRepository.getReferenceById(data.id());
        Doctor.updateData(data);
    }
    



}

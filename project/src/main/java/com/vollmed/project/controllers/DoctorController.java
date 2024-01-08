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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional // transação ativa com o banco de dados pois é um insert/ método de escrita
    public ResponseEntity registerDoctor(@RequestBody @Valid RequestDoctor dataDoctor, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(dataDoctor);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(dataDoctor);
    }

    @GetMapping
    public ResponseEntity<List<RequestDataDoctor>> findAllActiveDoctors() {
        List<Doctor> activeDoctors = doctorRepository.findAllActiveDoctors();

        List<RequestDataDoctor> requestDataDoctors = activeDoctors.stream()
                .map(doctor -> {
                    return new RequestDataDoctor(doctor);
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(requestDataDoctors);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateData(@RequestBody @Valid RequestUpdateDoctor data) {
        var Doctor = doctorRepository.getReferenceById(data.id());
        Doctor.updateData(data);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity deleteDoctorById(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.status();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(doctor.get());
    }
}

package com.vollmed.project.repositories;

import com.vollmed.project.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d FROM Doctor d WHERE d.active = true")
    List<Doctor> findAllActiveDoctors();
}

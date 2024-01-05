package com.vollmed.project.entities.records;

import com.vollmed.project.entities.Address;
import com.vollmed.project.entities.enums.Specialty;

public record RequestDoctor(String name, String email, String crm, Specialty specialty, Address address) {
}


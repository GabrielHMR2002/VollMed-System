package com.vollmed.project.entities.records;

import com.vollmed.project.entities.Address;
import com.vollmed.project.entities.enums.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RequestDoctor(
        @NotBlank String name,
        @Email @NotBlank  String email,
        @NotBlank
        @Pattern(regexp = "//d{4,6}") // de 4 a 6 digitos
        String crm,
        @NotNull Specialty specialty,
        @NotNull @Valid Address address) {

}


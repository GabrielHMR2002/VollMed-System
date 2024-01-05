package com.vollmed.project.entities.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RequestAddress(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "//d{8}")
        String postalCode,

        @NotBlank
        String city,
        @NotBlank
        String state,

        String complement,

        String number) {
}


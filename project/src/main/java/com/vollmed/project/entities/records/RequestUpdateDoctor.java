package com.vollmed.project.entities.records;

import jakarta.validation.constraints.NotNull;

public record RequestUpdateDoctor(
        @NotNull
        Long id,
        String name,
        String phone,
        RequestAddress address) {
}

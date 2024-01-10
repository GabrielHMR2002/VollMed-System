package com.vollmed.project.entities.records;

import jakarta.validation.constraints.NotBlank;

public record RequestUser(
        Long id,


        String login,

        String password
) {
}

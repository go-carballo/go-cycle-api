package com.biciman.go.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateBiciDto(
        @NotBlank(message = "El título no puede estar vacío")
        String titulo
) {
}

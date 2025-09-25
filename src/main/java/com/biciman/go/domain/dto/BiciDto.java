package com.biciman.go.domain.dto;

import java.time.LocalDate;

public record BiciDto(
        String titulo,
        String marca,
        String gener,
        String tipo
) {
}

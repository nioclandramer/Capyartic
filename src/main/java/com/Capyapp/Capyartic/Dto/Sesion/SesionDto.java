package com.Capyapp.Capyartic.Dto.Sesion;

import com.Capyapp.Capyartic.Entidades.EstadoSesion;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record SesionDto(
        Long id,
        LocalTime horaInicio,
        LocalTime horaFinal,
        LocalDateTime fecha,
        EstadoSesion estadoSesion
) {
}

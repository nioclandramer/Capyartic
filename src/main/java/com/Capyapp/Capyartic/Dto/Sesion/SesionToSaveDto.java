package com.Capyapp.Capyartic.Dto.Sesion;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Entidades.EstadoSesion;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record SesionToSaveDto(LocalTime horaInicio, LocalTime horaFinal, LocalDateTime fecha, EstadoSesion estadoSesion,
                              TemaDto tema , CategoriaDto categoriaDto) {
}

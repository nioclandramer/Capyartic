package com.Capyapp.Capyartic.Dto.Tutoria;

import com.Capyapp.Capyartic.Dto.Alumno.AlumnoDto;
import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Tutor.TutorDto;
import com.Capyapp.Capyartic.Entidades.EstadoTutoria;

public record TutoriaToSaveDto(
        EstadoTutoria estadoTutoria,
        TutorDto tutorDto,
        AlumnoDto alumnoDto,
        CategoriaDto categoriaDto) {
}

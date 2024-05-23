package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;

import java.util.Collections;
import java.util.List;

public record AlumnoDto(
        List<TutoriaDto> tutoria
) {
    public List<TutoriaDto> tutoria(){
        return Collections.unmodifiableList(tutoria);
    }
}

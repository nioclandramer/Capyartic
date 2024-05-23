package com.Capyapp.Capyartic.Dto.Tutor;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;

import java.util.Collections;
import java.util.List;

public record TutorDto(
        String tituloProfesional,
        List<TutoriaDto> tutoria
) {
    public List<TutoriaDto> tutoria(){
        return Collections.unmodifiableList(tutoria);
    }
}

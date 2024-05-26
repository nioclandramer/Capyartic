package com.Capyapp.Capyartic.Dto.Categoria;

import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;

import java.util.Collections;
import java.util.List;

public record CategoriaDto(
        String nombre,
        String descripcion,
        List<TutoriaDto> tutoriaDtos,
        List<TemaDto> temaDtos
) {
    public  List<TutoriaDto> getUnmodifiableTutorias(){
        return Collections.unmodifiableList(tutoriaDtos);
    }
    public List<TemaDto> getUnmodifiableTema(){
        return Collections.unmodifiableList(temaDtos);
    }
}

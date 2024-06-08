package com.Capyapp.Capyartic.Dto.Categoria;

import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;

import java.util.Collections;
import java.util.List;

public record CategoriaDto(Long id,
        String nombre,
        String descripcion,
        List<TutoriaDto> tutorias,
        List<TemaDto> temas
) {
    public  List<TutoriaDto> getUnmodifiableTutorias(){
        return Collections.unmodifiableList(tutorias);
    }
    public List<TemaDto> getUnmodifiableTema(){
        return Collections.unmodifiableList(temas);
    }
}

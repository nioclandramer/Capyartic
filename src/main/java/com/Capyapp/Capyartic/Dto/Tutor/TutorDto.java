package com.Capyapp.Capyartic.Dto.Tutor;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import lombok.Data;

import java.util.Collections;
import java.util.List;
@Data
public class TutorDto extends UsuarioDto {
    private String tituloProfesional;
    private List<TutoriaDto> tutoriaDtos;
    private List<CategoriaDto> categoriaDtos;

    public  List<TutoriaDto> getUnmodifiableTutorias(){
        return  Collections.unmodifiableList(tutoriaDtos);
    }
    public  List<CategoriaDto> getUnmodifiableCategorias(){
        return Collections.unmodifiableList(categoriaDtos);
    }
}

package com.Capyapp.Capyartic.Dto.Tutor;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioToSaveDto;
import lombok.Data;

import java.util.List;
@Data
public class TutorToSaveDto extends UsuarioToSaveDto {
    private String tituloProfesional;
    private List<TutoriaDto> tutoriaDtos;
    private List<CategoriaDto> categoriaDtos;
}

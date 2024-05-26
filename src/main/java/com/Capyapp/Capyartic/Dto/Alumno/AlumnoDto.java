package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class AlumnoDto extends UsuarioDto{
    private NivelEducativoDto nivelEducativoDto;
    private List<TutoriaDto> tutoriaDtos;

    public List<TutoriaDto> getUnmodifiableTutorias(){
        return Collections.unmodifiableList(tutoriaDtos);
    }
}

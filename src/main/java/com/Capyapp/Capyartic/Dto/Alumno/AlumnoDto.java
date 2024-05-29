package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class AlumnoDto extends UsuarioDto {
    private String nivelEducativo;
    private List<TutoriaDto> tutorias;

    public List<TutoriaDto> getUnmodifiableTutorias(){
        return Collections.unmodifiableList(tutorias);
    }
}

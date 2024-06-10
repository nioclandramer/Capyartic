package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class AlumnoDto extends UsuarioDto { private Long id;
    private NivelEducativoDto nivelEducativo;
    private List<TutoriaDto> tutorias;

}

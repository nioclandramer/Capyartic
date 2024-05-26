package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoToSaveDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioToSaveDto;
import lombok.Data;

import java.util.List;
@Data
public class AlumnoToSaveDto extends UsuarioToSaveDto
{
    private NivelEducativoDto nivelEducativo;
}

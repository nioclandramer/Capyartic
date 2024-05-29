package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import lombok.Data;

@Data
public class AlumnoToSaveDto extends UsuarioDto
{
    private NivelEducativoDto nivelEducativo;
}

package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import lombok.Data;

@Data
public class AlumnoToSaveDto extends UsuarioDto
{
    private NivelEducativo nivelEducativo;
}

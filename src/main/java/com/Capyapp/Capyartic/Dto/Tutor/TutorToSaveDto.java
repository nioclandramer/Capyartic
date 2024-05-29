package com.Capyapp.Capyartic.Dto.Tutor;

import com.Capyapp.Capyartic.Dto.Usuario.UsuarioDto;
import lombok.Data;

@Data
public class TutorToSaveDto extends UsuarioDto {
    private String tituloProfesional;
}

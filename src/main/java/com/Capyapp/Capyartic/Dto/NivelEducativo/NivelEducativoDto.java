package com.Capyapp.Capyartic.Dto.NivelEducativo;

import com.Capyapp.Capyartic.Dto.Alumno.AlumnoDto;

import java.util.Collections;
import java.util.List;

public record NivelEducativoDto(
        Long id,
        String nivelEducativo,
        List<AlumnoDto> alumno
) {
    public List<AlumnoDto> alumno(){
        return Collections.unmodifiableList(alumno);
    }
}

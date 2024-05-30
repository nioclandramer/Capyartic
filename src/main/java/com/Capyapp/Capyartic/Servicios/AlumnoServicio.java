package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Alumno.AlumnoDto;
import com.Capyapp.Capyartic.Dto.Alumno.AlumnoToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.AlumnoNotFoundException;

public interface AlumnoServicio {
    AlumnoDto guardarAlumno(AlumnoToSaveDto alumno);
    AlumnoDto actualizarAlumno(Long id,AlumnoToSaveDto alumno);
    AlumnoDto findById(Long id)throws AlumnoNotFoundException;
    void deleteById(Long id)throws AlumnoNotFoundException;
}

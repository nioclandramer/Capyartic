package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Alumno.AlumnoDto;
import com.Capyapp.Capyartic.Dto.Alumno.AlumnoToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.AlumnoNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AlumnoServicio {
    AlumnoDto guardarAlumno(AlumnoToSaveDto alumno);
    AlumnoDto actualizarAlumno(Long id,AlumnoToSaveDto alumno);
    AlumnoDto findById(Long id)throws AlumnoNotFoundException;
    void deleteById(Long id)throws AlumnoNotFoundException;
    Optional<List<AlumnoDto>> getAllAlumnos();
}

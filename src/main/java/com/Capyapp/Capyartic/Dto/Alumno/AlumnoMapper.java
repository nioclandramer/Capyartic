package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Entidades.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoMapper INSTANCE= Mappers.getMapper(AlumnoMapper.class);
    AlumnoDto alumnoDtoToAlumno(Alumno alumno);
    AlumnoDto alumnoToAlumnoDto(Alumno alumno);
    Alumno alumnoToSaveDtoToAlumno(AlumnoToSaveDto alumnoToSaveDto);
}



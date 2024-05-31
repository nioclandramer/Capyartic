package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Entidades.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    @Mapping(target = "tutorias", source = "tutorias")
    @Mapping(target = "nivelEducativo", source = "nivelEducativo")
    AlumnoDto toAlumnoDto(Alumno alumno);

    @Mapping(target = "nivelEducativo", source = "nivelEducativo")
    AlumnoToSaveDto toAlumnoToSaveDto(Alumno alumno);

    @Mapping(target = "tutorias", ignore = true) // Ignore or map if needed
    Alumno toAlumno(AlumnoDto alumnoDto);

    @Mapping(target = "tutorias", ignore = true) // Ignore or map if needed
    Alumno toAlumno(AlumnoToSaveDto alumnoToSaveDto);
}

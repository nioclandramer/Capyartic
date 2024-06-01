package com.Capyapp.Capyartic.Dto.Alumno;

import com.Capyapp.Capyartic.Entidades.Alumno;
import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoMapper INSTANCE= Mappers.getMapper(AlumnoMapper.class);

    AlumnoDto alumnoToAlumnoDto(Alumno alumno);

    Alumno alumnoToSaveDtoToAlumno(AlumnoToSaveDto alumnoToSaveDto);


}



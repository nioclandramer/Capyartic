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
    @Mapping(source = "nivelEducativo", target = "nivelEducativo", qualifiedByName = "stringToNivelEducativo")
    Alumno alumnoDtoToAlumno(AlumnoDto alumnoDto);

    @Mapping(source = "nivelEducativo", target = "nivelEducativo", qualifiedByName = "nivelEducativoToString")
    AlumnoDto alumnoToAlumnoDto(Alumno alumno);

    @Mapping(source = "nivelEducativo", target = "nivelEducativo", qualifiedByName = "nivelEducativoToString")
    Alumno alumnoToSaveDtoToAlumno(AlumnoToSaveDto alumnoToSaveDto);

    @Named("stringToNivelEducativo")
    default NivelEducativo stringToNivelEducativo(String nombre) {
        if (nombre == null) {
            return null;
        }
        NivelEducativo nivelEducativo = new NivelEducativo();
        nivelEducativo.setNombre(nombre);
        return nivelEducativo;
    }

    @Named("nivelEducativoToString")
    default String nivelEducativoToString(NivelEducativo nivelEducativo) {
        if (nivelEducativo == null) {
            return null;
        }
        return nivelEducativo.getNombre();
    }
}



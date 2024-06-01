package com.Capyapp.Capyartic.Dto.Tutor;

import com.Capyapp.Capyartic.Entidades.Tutor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    @Mapping(source = "tituloProfesional", target = "tituloProfesional")
    TutorDto tutorToDto(Tutor tutor);

    @Mapping(source = "tituloProfesional", target = "tituloProfesional")
    Tutor dtoToTutor(TutorDto tutorDto);

    Tutor toEntity(TutorToSaveDto tutorToSaveDto);

}

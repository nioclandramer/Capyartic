package com.Capyapp.Capyartic.Dto.Tutor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    @Mapping(source = "tituloProfesional", target = "tituloProfesional")
    TutorDto toTutorDto(TutorToSaveDto tutorToSaveDto);

    @Mapping(source = "tituloProfesional", target = "tituloProfesional")
    TutorToSaveDto toTutorToSaveDto(TutorDto tutorDto);
}

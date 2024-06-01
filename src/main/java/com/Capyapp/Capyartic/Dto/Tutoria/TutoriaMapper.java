package com.Capyapp.Capyartic.Dto.Tutoria;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
public interface TutoriaMapper {
    TutoriaMapper INSTANCE = Mappers.getMapper(TutoriaMapper.class);

    TutoriaDto toTutoriaDto(TutoriaToSaveDto tutoriaToSaveDto);

    TutoriaToSaveDto toTutoriaToSaveDto(TutoriaDto tutoriaDto);


}

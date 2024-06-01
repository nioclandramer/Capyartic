package com.Capyapp.Capyartic.Dto.Tutoria;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Tutoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TutoriaMapper {
    TutoriaMapper INSTANCE = Mappers.getMapper(TutoriaMapper.class);
    Tutoria tutoriaDtotoAdmin(TutoriaDto tutoriaDto);
    TutoriaDto tutoriaToTutoriaDto(Tutoria tutoria);
    Tutoria tutoriaToSaveDtoTutoria(TutoriaToSaveDto tutoriaToSaveDto);


}

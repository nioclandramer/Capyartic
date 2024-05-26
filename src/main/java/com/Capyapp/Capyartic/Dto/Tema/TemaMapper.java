package com.Capyapp.Capyartic.Dto.Tema;

import com.Capyapp.Capyartic.Entidades.Tema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TemaMapper {
     TemaMapper INSTANCE= Mappers.getMapper(TemaMapper.class);
     Tema temaDtoToTema(TemaDto temaDto);
     TemaDto temaToTemaDto(Tema tema);
     TemaToSaveDto temaToSaveDto(Tema tema);
}

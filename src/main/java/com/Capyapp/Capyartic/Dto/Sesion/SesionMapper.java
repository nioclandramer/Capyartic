package com.Capyapp.Capyartic.Dto.Sesion;

import com.Capyapp.Capyartic.Entidades.Sesion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SesionMapper {
    SesionMapper INSTANCE= Mappers.getMapper(SesionMapper.class);
    SesionDto SesionToSesionDto(Sesion sesion);
    Sesion SesionDtoToSesion(SesionDto sesion);
}

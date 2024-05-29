package com.Capyapp.Capyartic.Dto.NivelEducativo;

import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface NivelEducativoMapper {
    NivelEducativoMapper INSTANCE = Mappers.getMapper(NivelEducativoMapper.class);

    NivelEducativo toNivelEducativoDto(NivelEducativoDto nivelEducativoDto);

    NivelEducativoDto toNivelEducativoDto(NivelEducativoToSaveDto nivelEducativoToSaveDto);

    NivelEducativoToSaveDto toNivelEducativoToSaveDto(NivelEducativoDto nivelEducativoDto);
}

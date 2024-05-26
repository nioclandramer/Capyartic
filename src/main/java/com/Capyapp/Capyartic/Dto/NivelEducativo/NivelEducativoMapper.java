package com.Capyapp.Capyartic.Dto.NivelEducativo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface NivelEducativoMapper {
    NivelEducativoMapper INSTANCE = Mappers.getMapper(NivelEducativoMapper.class);

    NivelEducativoDto toNivelEducativoDto(NivelEducativoToSaveDto nivelEducativoToSaveDto);

    NivelEducativoToSaveDto toNivelEducativoToSaveDto(NivelEducativoDto nivelEducativoDto);
}

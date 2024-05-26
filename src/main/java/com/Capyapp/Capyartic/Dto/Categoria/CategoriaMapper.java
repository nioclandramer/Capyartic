package com.Capyapp.Capyartic.Dto.Categoria;

import com.Capyapp.Capyartic.Entidades.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE= Mappers.getMapper(CategoriaMapper.class);
    Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto);
    CategoriaDto categoriaToCategoriaDto(Categoria categoria);
    Categoria CategoriaToSaveDtoToCategoria(CategoriaToSaveDto categoriaToSaveDto);
}

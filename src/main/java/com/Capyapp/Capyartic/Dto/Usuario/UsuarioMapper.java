package com.Capyapp.Capyartic.Dto.Usuario;

import com.Capyapp.Capyartic.Entidades.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
}

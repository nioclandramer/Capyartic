package com.Capyapp.Capyartic.Dto.Administrador;
import com.Capyapp.Capyartic.Entidades.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AdministradorMapper {
    AdministradorMapper INSTANCE= Mappers.getMapper(AdministradorMapper.class);
    AdministradorDto adminDtoToAdmin(Admin admin);
    AdministradorDto adminToAdminDto(Admin adminDto);
    Admin administradorToSaveDtoToAdmin(AdministradorToSaveDto administradorToSaveDtoDto);
}

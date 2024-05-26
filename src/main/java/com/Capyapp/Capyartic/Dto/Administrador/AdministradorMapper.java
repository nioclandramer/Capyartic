package com.Capyapp.Capyartic.Dto.Administrador;
import com.Capyapp.Capyartic.Entidades.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AdministradorMapper {
    AdministradorMapper INSTANCE= Mappers.getMapper(AdministradorMapper.class);
    Admin adminDtoToAdmin(AdministradorDto adminDto);
    AdministradorDto adminToAdminDto(Admin admin);
    Admin administradorToSaveDtoToAdmin(AdministradorToSaveDto administradorToSaveDtoDto);



}

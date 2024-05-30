package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Administrador.AdministradorDto;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.AdministradorNotFoundException;

public interface AdminServicio {
    AdministradorDto guardarAdministrador(AdministradorToSaveDto administrador);
    AdministradorDto actualizarAdministrador(Long id,AdministradorToSaveDto administrador);
    AdministradorDto findById(Long id)throws AdministradorNotFoundException;
    void deleteById(Long id)throws  AdministradorNotFoundException;
}

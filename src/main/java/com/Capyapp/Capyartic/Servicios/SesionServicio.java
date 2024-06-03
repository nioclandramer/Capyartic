package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Sesion.SesionDto;
import com.Capyapp.Capyartic.Dto.Sesion.SesionToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.SesionNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SesionServicio {
    SesionDto guardarSesion(SesionToSaveDto sesion);
    SesionDto actualizarSesion(Long id,SesionToSaveDto sesion);
    SesionDto findById(Long id)throws SesionNotFoundException;
    void eliminarSesion(Long id)throws SesionNotFoundException;
    Optional<List<SesionDto>> getAllSesiones();
}

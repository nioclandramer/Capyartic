package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Sesion.SesionDto;
import com.Capyapp.Capyartic.Dto.Sesion.SesionToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.SesionNotFoundException;
import com.Capyapp.Capyartic.Repositorios.AlumnoRepositorio;

public class SesionServicioIMPL implements SesionServicio {
    private final AlumnoRepositorio alumnoRepositorio;

    public SesionServicioIMPL(AlumnoRepositorio alumnoRepositorio) {
        this.alumnoRepositorio = alumnoRepositorio;
    }

    @Override
    public SesionDto guardarSesion(SesionToSaveDto sesion) {
        return null;
    }

    @Override
    public SesionDto actualizarSesion(Long id, SesionToSaveDto sesion) {
        return null;
    }

    @Override
    public SesionDto findById(Long id) throws SesionNotFoundException {
        return null;
    }

    @Override
    public void eliminarSesion(Long id) throws SesionNotFoundException {

    }
}

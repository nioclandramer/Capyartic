package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Sesion.SesionDto;
import com.Capyapp.Capyartic.Dto.Sesion.SesionMapper;
import com.Capyapp.Capyartic.Dto.Sesion.SesionToSaveDto;
import com.Capyapp.Capyartic.Entidades.Sesion;
import com.Capyapp.Capyartic.Excepciónes.SesionNotFoundException;
import com.Capyapp.Capyartic.Repositorios.SesionRepositorio;

import java.util.List;
import java.util.Optional;

public class SesionServicioIMPL implements SesionServicio {
    private final SesionRepositorio sesionRepositorio;

    public SesionServicioIMPL(SesionRepositorio sesionRepositorio) {
        this.sesionRepositorio = sesionRepositorio;
    }

    @Override
    public SesionDto guardarSesion(SesionToSaveDto sesion) {
        Sesion sesion1= SesionMapper.INSTANCE.SesionToSaveDto(sesion);
        Sesion sesionGuardada= sesionRepositorio.save(sesion1);
        return SesionMapper.INSTANCE.sesionDtoToSesion(sesionGuardada);
    }

    @Override
    public SesionDto actualizarSesion(Long id, SesionToSaveDto sesion) {
        Sesion sesion1= SesionMapper.INSTANCE.SesionToSaveDto(sesion);
        Sesion sesionExistente= sesionRepositorio.findById(id).orElseThrow(()-> new SesionNotFoundException("se no existe en el sistema"));
        sesionExistente.setHoraInicio(sesion1.getHoraInicio());
        sesionExistente.setHoraFinal(sesion1.getHoraFinal());
        sesionExistente.setFecha(sesion1.getFecha());
        sesionExistente.setEstadoSesion(sesion1.getEstadoSesion());
        sesionExistente.setTema(sesion1.getTema());
        sesionExistente.setTutoria(sesion1.getTutoria());
        sesionExistente=sesionRepositorio.save(sesionExistente);
        return SesionMapper.INSTANCE.sesionDtoToSesion(sesionExistente);
    }

    @Override
    public SesionDto findById(Long id) throws SesionNotFoundException {
        Sesion sesion = sesionRepositorio.findById(id).orElseThrow(()-> new SesionNotFoundException("se no existe en el sistema"));
        return SesionMapper.INSTANCE.sesionDtoToSesion(sesion);
    }

    @Override
    public void eliminarSesion(Long id) throws SesionNotFoundException {
        Sesion sesion = sesionRepositorio.findById(id).orElseThrow(()-> new SesionNotFoundException("se no existe en el sistema"));
        sesionRepositorio.delete(sesion);
    }

    @Override
    public Optional<List<SesionDto>> getAllSesiones() {
        List<Sesion> sesiones= sesionRepositorio.findAll();
        List<SesionDto> sesionesDto=sesiones.stream().map(SesionMapper.INSTANCE::sesionDtoToSesion).toList();
        return Optional.of(sesionesDto);
    }
}

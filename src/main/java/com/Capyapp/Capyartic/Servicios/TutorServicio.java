package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Tutor.TutorDto;
import com.Capyapp.Capyartic.Dto.Tutor.TutorToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.TutorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TutorServicio {
    TutorDto guardar(TutorToSaveDto tutor);
    void eliminarTutor(Long id) throws TutorNotFoundException;
    Optional<TutorDto> validarTutor(String nombreUsuario, String contrasena) throws TutorNotFoundException;
    Optional<TutorDto> buscarTutorPorId(Long id) throws TutorNotFoundException;
    TutorDto actualizarTutor(Long id,TutorToSaveDto tutor) throws TutorNotFoundException;
    List<TutorDto> mostrarTuroresPorCategoria(String categoria) throws TutorNotFoundException;

}
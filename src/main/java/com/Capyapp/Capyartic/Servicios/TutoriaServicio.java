package com.Capyapp.Capyartic.Servicios;
import java.util.List;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.EstadoTutoria;
import com.Capyapp.Capyartic.Entidades.Tutoria;
import com.Capyapp.Capyartic.Excepciónes.TutoriaNotFoundException;


import java.util.Optional;

public interface TutoriaServicio {
    TutoriaDto guardarTutoria(TutoriaToSaveDto tutoriaToSaveDto);
    TutoriaDto actualizarTutorua(TutoriaToSaveDto Turia, Long idTurtoria) throws TutoriaNotFoundException;
    Optional<List<TutoriaDto>> mostrarTutoriasdeTutor(Long idTutor)throws TutoriaNotFoundException;
    Optional<List<TutoriaDto>> getAllTutoria()throws TutoriaNotFoundException;
    Optional<List<TutoriaDto>> mostrarTutoriasdeAlumno(Long idAlumno)throws TutoriaNotFoundException;
    void deleteById(Long idTutoria) throws TutoriaNotFoundException;
}

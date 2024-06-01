package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaMapper;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Tutoria;
import com.Capyapp.Capyartic.Excepciónes.TutorNotFoundException;
import com.Capyapp.Capyartic.Excepciónes.TutoriaNotFoundException;
import com.Capyapp.Capyartic.Repositorios.TutoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutoriaServicioIMPL implements TutoriaServicio{
    private final TutoriaRepositorio tutoriaRepositorio;

    public TutoriaServicioIMPL (TutoriaRepositorio tutoriaRepositorio) {
        this.tutoriaRepositorio=tutoriaRepositorio;
    }

    @Override
    public TutoriaDto guardarTutoria( TutoriaToSaveDto tutoria) {
        Tutoria tutoria1= TutoriaMapper.INSTANCE.tutoriaToSaveDtoTutoria(tutoria);
        Tutoria tutoriaGuardada= tutoriaRepositorio.save(tutoria1);
        return TutoriaMapper.INSTANCE.tutoriaToTutoriaDto(tutoriaGuardada);
    }

    @Override
    public TutoriaDto actualizarTutorua(TutoriaToSaveDto tutoria, Long idTurtoria) throws TutoriaNotFoundException {
        Tutoria tutoria1 =TutoriaMapper.INSTANCE.tutoriaToSaveDtoTutoria(tutoria);
        Tutoria tutoriaExiste=tutoriaRepositorio.findById(idTurtoria).orElseThrow(()->new TutorNotFoundException("Tutoria no existe"));
        tutoriaExiste.setEstadoTutoria(tutoria1.getEstadoTutoria());
        return TutoriaMapper.INSTANCE.tutoriaToTutoriaDto(tutoriaExiste);
    }

    @Override
    public Optional<List<TutoriaDto>> mostrarTutoriasdeTutor(Long idTutor) throws TutoriaNotFoundException {

        return Optional.empty();
    }

    @Override
    public Optional<List<TutoriaDto>> getAllTutoria() throws TutoriaNotFoundException {
        List<Tutoria> tutorias = tutoriaRepositorio.findAll();
        List<TutoriaDto> tutoriasDto =tutorias.stream().map(TutoriaMapper.INSTANCE::tutoriaToTutoriaDto).collect(Collectors.toList());
        return Optional.of(tutoriasDto);
    }

    @Override
    public Optional<List<TutoriaDto>> mostrarTutoriasdeAlumno(Long idAlumno) throws TutoriaNotFoundException {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long idTutoria) throws TutoriaNotFoundException {
        Tutoria tutoria= tutoriaRepositorio.findById(idTutoria).orElseThrow(()->new TutorNotFoundException("Tutoria no existe"));
        tutoriaRepositorio.deleteById(idTutoria);
    }
}

package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Tutor.TutorDto;
import com.Capyapp.Capyartic.Dto.Tutor.TutorMapper;
import com.Capyapp.Capyartic.Dto.Tutor.TutorToSaveDto;
import com.Capyapp.Capyartic.Entidades.Tutor;
import com.Capyapp.Capyartic.Excepciónes.TutorNotFoundException;
import com.Capyapp.Capyartic.Repositorios.TutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorServicioIMPL implements TutorServicio {
    private final TutorRepositorio tutorRepositorio;

    public TutorServicioIMPL(TutorRepositorio tutorRepositorio){
        this.tutorRepositorio = tutorRepositorio;
    }
    @Override
    public TutorDto guardar(TutorToSaveDto tutor) {
        Tutor tutor1 = TutorMapper.INSTANCE.toEntity(tutor);
        Tutor tutorGuardado=tutorRepositorio.save(tutor1);
        return TutorMapper.INSTANCE.tutorToDto(tutorGuardado);
    }

    @Override
    public void eliminarTutor(Long id) throws TutorNotFoundException {
        Tutor tutor = tutorRepositorio.findById(id).orElseThrow(()->new TutorNotFoundException("Tutor no encontrado"));
        tutorRepositorio.delete(tutor);
    }

    @Override
    public List<TutorDto> getAllTutor() throws TutorNotFoundException {
        List<Tutor> tutors=tutorRepositorio.findAll();
        List<TutorDto> tutorDtos=tutors.stream().map(TutorMapper.INSTANCE::tutorToDto).collect(Collectors.toList());
        return tutorDtos;
    }

    @Override
    public Optional<TutorDto> validarTutor(String nombreUsuario, String contrasena) throws TutorNotFoundException {
        Tutor tutor = tutorRepositorio.findTutorByNombreUsuarioAndContrasena(nombreUsuario,contrasena).orElseThrow(()->new TutorNotFoundException("Usuario Tutor o Contraseña no coinciden"));
        return Optional.ofNullable(TutorMapper.INSTANCE.tutorToDto(tutor));
    }

    @Override
    public Optional<TutorDto> buscarTutorPorId(Long id) throws TutorNotFoundException {
        Tutor tutor=tutorRepositorio.findById(id).orElseThrow(()->new TutorNotFoundException("Tutor no encontrado"));
        return Optional.ofNullable(TutorMapper.INSTANCE.tutorToDto(tutor));
    }

    @Override
    public TutorDto actualizarTutor(Long id,TutorToSaveDto tutor) throws TutorNotFoundException {
        Tutor tutor1 = TutorMapper.INSTANCE.toEntity(tutor);
        Tutor tutorExiste=tutorRepositorio.findById(id).orElseThrow(()->new TutorNotFoundException("Tutor no encontrado"));
        tutorExiste.setPrimerNombre(tutor1.getPrimerNombre());
        tutorExiste.setSegundoNombre(tutor1.getSegundoNombre());
        tutorExiste.setPrimerApellido(tutor1.getPrimerApellido());
        tutorExiste.setSegundoApellido(tutor1.getSegundoApellido());
        tutorExiste.setNombreUsuario(tutor1.getNombreUsuario());
        tutorExiste.setEmail(tutor1.getEmail());
        tutorExiste.setNumeroTelefono(tutor1.getNumeroTelefono());
        tutorExiste.setContrasena(tutor1.getContrasena());
        tutorExiste.setFechaRegistro(tutor1.getFechaRegistro());
        tutorExiste.setCategorias(tutor1.getCategorias());
        tutorExiste.setTituloProfesional(tutor1.getTituloProfesional());
        tutorExiste.setSexo(tutor1.getSexo());
        tutorExiste.setFechaNacimiento(tutor1.getFechaNacimiento());
        tutorExiste.setEstadoUsuario(tutor1.getEstadoUsuario());
        tutorExiste.setRolUser(tutor1.getRolUser());
        tutorExiste= tutorRepositorio.save(tutorExiste);
        return TutorMapper.INSTANCE.tutorToDto(tutorExiste);
    }

    @Override
    public List<TutorDto> mostrarTuroresPorCategoria(String categoria) throws TutorNotFoundException {
        List<Tutor> tutors=tutorRepositorio.findTutorsByCategoriaNombreAndEstadoActivo(categoria);
        List<TutorDto> tutorDtos=tutors.stream().map(TutorMapper.INSTANCE::tutorToDto).collect(Collectors.toList());
        return tutorDtos;
    }
}
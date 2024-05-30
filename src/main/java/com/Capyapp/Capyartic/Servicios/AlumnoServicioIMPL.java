package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Alumno.AlumnoDto;
import com.Capyapp.Capyartic.Dto.Alumno.AlumnoMapper;
import com.Capyapp.Capyartic.Dto.Alumno.AlumnoToSaveDto;
import com.Capyapp.Capyartic.Entidades.Alumno;
import com.Capyapp.Capyartic.Excepciónes.AlumnoNotFoundException;
import com.Capyapp.Capyartic.Repositorios.AlumnoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServicioIMPL implements AlumnoServicio{
    private final AlumnoRepositorio alumnoRepositorio;

    public AlumnoServicioIMPL(AlumnoRepositorio alumnoRepositorio) {
        this.alumnoRepositorio = alumnoRepositorio;
    }

    @Override
    public AlumnoDto guardarAlumno(AlumnoToSaveDto alumno) {
        Alumno alumno1=AlumnoMapper.INSTANCE.alumnoToSaveDtoToAlumno(alumno);
        Alumno alumnoGuardado=alumnoRepositorio.save(alumno1);
        return AlumnoMapper.INSTANCE.alumnoToAlumnoDto(alumnoGuardado);
    }

    @Override
    public AlumnoDto actualizarAlumno(Long id, AlumnoToSaveDto alumno) {
        Alumno alumno1=AlumnoMapper.INSTANCE.alumnoToSaveDtoToAlumno(alumno);
        Alumno alumnoExiste=alumnoRepositorio.findById(id).orElseThrow(()-> new AlumnoNotFoundException("Alumno no encontrado"));
        alumnoExiste.setPrimerNombre(alumno1.getPrimerNombre());
        alumnoExiste.setSegundoNombre(alumno1.getSegundoNombre());
        alumnoExiste.setPrimerApellido(alumno1.getPrimerApellido());
        alumnoExiste.setSegundoApellido(alumno1.getSegundoApellido());
        alumnoExiste.setEmail(alumno1.getEmail());
        alumnoExiste.setNumeroTelefono(alumno1.getNumeroTelefono());
        alumnoExiste.setSexo(alumno1.getSexo());
        alumnoExiste.setContraseña(alumno1.getContraseña());
        alumnoExiste.setNombreUsuario(alumno1.getNombreUsuario());
        alumnoExiste.setFechaRegistro(alumno1.getFechaRegistro());
        alumnoExiste.setFechaNacimiento(alumno1.getFechaNacimiento());
        alumnoExiste.setRolUser(alumno1.getRolUser());
        alumnoExiste.setEstadoUsuario(alumno1.getEstadoUsuario());
        alumnoExiste.setTutorias(alumno1.getTutorias());
        alumnoExiste.setNivelEducativo(alumno1.getNivelEducativo());
        alumnoExiste=alumnoRepositorio.save(alumnoExiste);
        return AlumnoMapper.INSTANCE.alumnoToAlumnoDto(alumnoExiste);
    }

    @Override
    public AlumnoDto findById(Long id) throws AlumnoNotFoundException {
        Alumno alumno=alumnoRepositorio.findById(id).orElseThrow(()-> new AlumnoNotFoundException("Alumno no encontrado"));
        return AlumnoMapper.INSTANCE.alumnoToAlumnoDto(alumno);
    }

    @Override
    public void deleteById(Long id) throws AlumnoNotFoundException {
        Alumno alumno=alumnoRepositorio.findById(id).orElseThrow(()-> new AlumnoNotFoundException("Alumno no encontrado"));
        alumnoRepositorio.delete(alumno);
    }
}

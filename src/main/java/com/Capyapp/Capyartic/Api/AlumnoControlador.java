package com.Capyapp.Capyartic.Api;

import com.Capyapp.Capyartic.Dto.Alumno.AlumnoDto;
import com.Capyapp.Capyartic.Dto.Alumno.AlumnoToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.AlumnoNotFoundException;
import com.Capyapp.Capyartic.Servicios.AlumnoServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/alumno")
public class AlumnoControlador {
    private final AlumnoServicio alumnoServicio;

    public AlumnoControlador(AlumnoServicio alumnoServicio) {
        this.alumnoServicio = alumnoServicio;
    }

    @PostMapping
    public ResponseEntity<AlumnoDto> create(@RequestBody @Valid AlumnoToSaveDto alumno){
        AlumnoDto alumnoDto= alumnoServicio.guardarAlumno(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDto);
    }

    @GetMapping()
    public ResponseEntity<Optional<List<AlumnoDto>>> getAlumnos(){
        Optional<List<AlumnoDto>> alumnosDto= alumnoServicio.getAllAlumnos();
        return ResponseEntity.ok().body(alumnosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> getAlumno(@PathVariable("id")Long idAlumno){
        try {
            AlumnoDto alumnoDto=alumnoServicio.findById(idAlumno);
            return ResponseEntity.ok().body(alumnoDto);
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid AlumnoToSaveDto alumno,Long idAlumno){
        try {
            AlumnoDto alumnoDto=alumnoServicio.actualizarAlumno(idAlumno,alumno);
            return ResponseEntity.noContent().build();
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long idAlumno){
        try {
            alumnoServicio.deleteById(idAlumno);
            return ResponseEntity.noContent().build();
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}

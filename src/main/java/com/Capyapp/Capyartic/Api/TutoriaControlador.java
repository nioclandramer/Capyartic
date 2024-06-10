package com.Capyapp.Capyartic.Api;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.EstadoTutoria;
import com.Capyapp.Capyartic.Servicios.TutoriaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tutoria")
public class TutoriaControlador {
    private final TutoriaServicio tutoriaServicio;
    public TutoriaControlador(TutoriaServicio tutoriaServicio) {
        this.tutoriaServicio=tutoriaServicio;
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TutoriaToSaveDto tutoria) {
        tutoriaServicio.guardarTutoria(tutoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TutoriaToSaveDto tutoria) {
        tutoriaServicio.actualizarTutoria(tutoria,id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<TutoriaDto>>> getTutoriaByTutor(@PathVariable Long id) {
        Optional<List<TutoriaDto>> tutorias = tutoriaServicio.mostrarTutoriasdeTutor(id);
        return ResponseEntity.ok().body(tutorias);
    }
    @GetMapping("/AllTutor")
    public ResponseEntity<Optional<List<TutoriaDto>>> getAll(){
        Optional<List<TutoriaDto>> tutorias = tutoriaServicio.getAllTutoria();
        return ResponseEntity.ok(tutorias);
    };

    @GetMapping("/byEstado")
    public ResponseEntity<Optional<List<TutoriaDto>>> mostrarPorTutoryEstado(@PathVariable Long idTutor, EstadoTutoria estadoT){
        Optional<List<TutoriaDto>> tutorias = tutoriaServicio.mostrarTutoriasTutorporEstado(idTutor,estadoT);
        return ResponseEntity.ok(tutorias);
    };

    @GetMapping("/byAlumno")
    public ResponseEntity<Optional<List<TutoriaDto>>> mostrarPorAlumno(@PathVariable Long idAlumno){
        Optional<List<TutoriaDto>> tutorias = tutoriaServicio.mostrarTutoriasdeAlumno(idAlumno);
        return ResponseEntity.ok(tutorias);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tutoriaServicio.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}

package com.Capyapp.Capyartic.Api;

import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
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

    @PutMapping
    public ResponseEntity<Void> update(@PathVariable Long idTutoria,@RequestBody TutoriaToSaveDto tutoria) {
        tutoriaServicio.actualizarTutoria(tutoria,idTutoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/tutor")
    public ResponseEntity<Optional<List<TutoriaDto>>> getTutoriaByTutor(@PathVariable Long idTutor) {
        Optional<List<TutoriaDto>> tutorias = tutoriaServicio.mostrarTutoriasdeTutor(idTutor);
        return ResponseEntity.ok(tutorias);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long idTutoria) {
        tutoriaServicio.deleteById(idTutoria);
        return ResponseEntity.noContent().build();

    }
}
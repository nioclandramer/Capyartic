package com.Capyapp.Capyartic.Api;

import com.Capyapp.Capyartic.Dto.Tutor.TutorDto;
import com.Capyapp.Capyartic.Dto.Tutor.TutorToSaveDto;
import com.Capyapp.Capyartic.Dto.Tutoria.TutoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Tutor;
import com.Capyapp.Capyartic.Servicios.TutorServicio;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tutor")
public class TutorControlador {
    private final TutorServicio tutorServicio;

    public TutorControlador(TutorServicio tutorServicio) {
        this.tutorServicio = tutorServicio;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TutorToSaveDto tutor) {
        tutorServicio.guardar(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<Void> update(@PathVariable Long idTutor,@RequestBody TutorToSaveDto tutor) {
        tutorServicio.actualizarTutor(idTutor,tutor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TutorDto>> getTutores() {
        List<TutorDto> tutores= tutorServicio.getAllTutor();
        return ResponseEntity.ok().body(tutores);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<TutorDto>> getTutorByCategoria(@PathParam("categoria") String nombreCategoria) {
        List<TutorDto> tutores= tutorServicio.mostrarTuroresPorCategoria(nombreCategoria);
        return ResponseEntity.ok().body(tutores);

    }

    @GetMapping("/id")
    public ResponseEntity<Optional<TutorDto>> getTutorById(@PathVariable Long idTutor) {
        Optional<TutorDto> tutores= tutorServicio.buscarTutorPorId(idTutor);
        return ResponseEntity.ok(tutores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long idTutor) {
        tutorServicio.eliminarTutor(idTutor);
        return ResponseEntity.noContent().build();
    }





}

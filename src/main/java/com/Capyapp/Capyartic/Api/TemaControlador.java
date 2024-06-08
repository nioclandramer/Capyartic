package com.Capyapp.Capyartic.Api;


import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Dto.Tema.TemaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Tema;
import com.Capyapp.Capyartic.Servicios.TemaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tema")
public class TemaControlador {
    private final TemaServicio temaServicio;

    public TemaControlador(TemaServicio temaServicio) {
        this.temaServicio = temaServicio;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TemaToSaveDto tema) {
        temaServicio.guardarTema(tema);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody TemaToSaveDto tema) {
        temaServicio.actualizarTema(id,tema);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Optional< List<TemaDto>>> getAll() {
        Optional< List<TemaDto>> temas=temaServicio.findAllTema();
        return ResponseEntity.ok().body(temas);
    }

    @GetMapping("/{id}")
    public ResponseEntity< TemaDto> getTemabyid(@PathVariable ("id") Long id) {
        TemaDto tema=temaServicio.findTemaById(id);
        return ResponseEntity.ok().body(tema);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        temaServicio.eliminarTema(id);
        return ResponseEntity.noContent().build();
    }
}

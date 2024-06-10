package com.Capyapp.Capyartic.Api;


import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoToSaveDto;
import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import com.Capyapp.Capyartic.Servicios.NivelEducativoServicio;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/nivelEducativo")
public class NivelEducativoControlador {
    private final NivelEducativoServicio nivelEducativoServicio;

    public NivelEducativoControlador(NivelEducativoServicio nivelEducativoServicio) {
        this.nivelEducativoServicio=nivelEducativoServicio;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NivelEducativoToSaveDto nivelEducativo) {
        nivelEducativoServicio.guardarNivelEducativo(nivelEducativo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody NivelEducativoToSaveDto nivelEducativo) {
        nivelEducativoServicio.actulizarNivelEducativo(id,nivelEducativo);
        return ResponseEntity.noContent().build();

    }


    @GetMapping()
    public ResponseEntity<Optional<List <NivelEducativoDto>>> getAll() {
        Optional<List <NivelEducativoDto>>  niveles=nivelEducativoServicio.findAllNivelEducativo();
        return ResponseEntity.ok().body(niveles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelEducativoDto> getById(@PathVariable Long id) {
        NivelEducativoDto  niveles=nivelEducativoServicio.findNivelEducativo(id);
        return ResponseEntity.ok().body(niveles);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        nivelEducativoServicio.deleteNivelEducativo(id);
        return ResponseEntity.noContent().build();
    }


}

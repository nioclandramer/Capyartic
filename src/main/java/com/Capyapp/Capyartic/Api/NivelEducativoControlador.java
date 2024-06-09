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

    @PutMapping
    public ResponseEntity<Void> update(@PathVariable Long idnivel,@RequestBody NivelEducativoToSaveDto nivelEducativo) {
        nivelEducativoServicio.actulizarNivelEducativo(idnivel,nivelEducativo);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @GetMapping("/nivelEducativo")
    public ResponseEntity<Optional<List <NivelEducativoDto>>> getAll() {
        Optional<List <NivelEducativoDto>>  niveles=nivelEducativoServicio.findAllNivelEducativo();
        return ResponseEntity.ok().body(niveles);
    }

    @GetMapping("/id")
    public ResponseEntity<NivelEducativoDto> getById(@PathVariable Long idnivel) {
        NivelEducativoDto  niveles=nivelEducativoServicio.findNivelEducativo(idnivel);
        return ResponseEntity.ok(niveles);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long idnivel) {
        nivelEducativoServicio.deleteNivelEducativo(idnivel);
        return ResponseEntity.noContent().build();
    }


}

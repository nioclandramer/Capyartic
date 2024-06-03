package com.Capyapp.Capyartic.Api;

import com.Capyapp.Capyartic.Dto.Sesion.SesionDto;
import com.Capyapp.Capyartic.Dto.Sesion.SesionToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.AlumnoNotFoundException;
import com.Capyapp.Capyartic.Servicios.SesionServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Sesion")
public class SesionControlador {
    private final SesionServicio sesionServicio;

    public SesionControlador(SesionServicio sesionServicio) {
        this.sesionServicio = sesionServicio;
    }

    @PostMapping
    public ResponseEntity<SesionDto> create(@RequestBody @Valid SesionToSaveDto sesion){
        SesionDto sesionDto= sesionServicio.guardarSesion(sesion);
        return ResponseEntity.status(HttpStatus.CREATED).body(sesionDto);
    }

    @GetMapping()
    public ResponseEntity<Optional<List<SesionDto>>> getSesiones(){
        Optional<List<SesionDto>> sesionesDto=sesionServicio.getAllSesiones();
        return ResponseEntity.ok().body(sesionesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionDto> getSesion(@PathVariable("id")Long idSesion){
        try {
            SesionDto sesionDto=sesionServicio.findById(idSesion);
            return ResponseEntity.ok().body(sesionDto);
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid SesionToSaveDto sesion,Long idSesion){
        try {
            SesionDto sesionDto=sesionServicio.actualizarSesion(idSesion,sesion);
            return ResponseEntity.noContent().build();
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long idSesion){
        try {
            sesionServicio.eliminarSesion(idSesion);
            return ResponseEntity.noContent().build();
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}

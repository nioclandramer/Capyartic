package com.Capyapp.Capyartic.Api;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorDto;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.AdministradorNotFoundException;
import com.Capyapp.Capyartic.Servicios.AdminServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
public class AdministradorControlador {
    private final AdminServicio adminServicio;

    public AdministradorControlador(AdminServicio adminServicio) {
        this.adminServicio = adminServicio;
    }

    @PostMapping
    public ResponseEntity<AdministradorDto> create(@RequestBody @Valid AdministradorToSaveDto administrador){
        AdministradorDto administradorDto=adminServicio.guardarAdministrador(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorDto);
    }

    @GetMapping()
    public ResponseEntity<Optional<List<AdministradorDto>>> getAdmins(){
        Optional<List<AdministradorDto>> administradoresDto= adminServicio.getAllAdministrador();
        return ResponseEntity.ok().body(administradoresDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDto> getAdministradorById(@PathVariable("id")Long idAdministrador){
        try {
            AdministradorDto administradorDto=adminServicio.findById(idAdministrador);
            return ResponseEntity.ok().body(administradorDto);
        }catch (AdministradorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid AdministradorToSaveDto administrador,Long idAdministrador){
        try {
            AdministradorDto administradorDto =adminServicio.actualizarAdministrador(idAdministrador,administrador);
            return ResponseEntity.noContent().build();
        }catch (AdministradorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long idAdministrador){
        adminServicio.deleteById(idAdministrador);
        return ResponseEntity.noContent().build();
    }
}

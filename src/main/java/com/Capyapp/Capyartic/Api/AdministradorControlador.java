package com.Capyapp.Capyartic.Api;
import com.Capyapp.Capyartic.Dto.Administrador.AdministradorDto;
import com.Capyapp.Capyartic.Servicios.AdminServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
public class AdministradorControlador {
    private final AdminServicio adminServicio;

    public AdministradorControlador(AdminServicio adminServicio) {
        this.adminServicio = adminServicio;
    }

    @GetMapping()
    public ResponseEntity<Optional<List<AdministradorDto>>> getAdmins(){
        Optional<List<AdministradorDto>> administradoresDto= adminServicio.getAllAdministrador();
        return ResponseEntity.ok().body(administradoresDto);
    }
}

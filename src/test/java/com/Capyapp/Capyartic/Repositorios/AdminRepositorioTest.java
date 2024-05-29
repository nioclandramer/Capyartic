package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.AstractIntegrationDBTest;
import com.Capyapp.Capyartic.Entidades.Admin;
import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class AdminRepositorioTest extends AstractIntegrationDBTest {
    AdminRepositorio adminRepositorio;

    @Autowired
    public AdminRepositorioTest(AdminRepositorio adminRepositorio) {
        this.adminRepositorio = adminRepositorio;
    }

    @BeforeEach
    void setUp() {
        adminRepositorio.deleteAll();
    }

    @Test
    void GiveAdmin_WhenCreate_ThenAdminIdIsSaved(){
        //Give
        Admin admin =new Admin();
        admin.setId(1L);
        admin.setPrimerNombre("Andres");
        admin.setSegundoNombre("Juan");
        admin.setPrimerApellido("Parra");
        admin.setSegundoApellido("Arias");
        admin.setEmail("Parrouianos_turulingo@gmail.com");
        admin.setNumeroTelefono(3005679876L);
        admin.setSexo("Masculino");
        admin.setContraseña("ÑioclaSala1234");
        admin.setNombreUsuario("Guillermito");
        admin.setFechaRegistro(LocalDateTime.of(2024, Month.AUGUST,10,8,20));
        admin.setFechaNacimiento(LocalDateTime.of(2002, Month.APRIL,1,8,20));
        admin.setRolUser(Rol.ALUMNO);
        admin.setEstadoUsuario(EstadoUsuario.ACTIVO);
        //When
        Admin adminsaved = adminRepositorio.save(admin);
        //Then
        assertThat(adminsaved).isNotNull();
        assertThat(adminsaved.getNombreUsuario()).isEqualTo("Guillermito");
    }

}
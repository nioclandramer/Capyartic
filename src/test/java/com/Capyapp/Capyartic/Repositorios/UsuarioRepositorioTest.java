package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.AstractIntegrationDBTest;
import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;
import com.Capyapp.Capyartic.Entidades.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositorioTest extends AstractIntegrationDBTest {
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioRepositorioTest(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @BeforeEach
    void setUp() {
        usuarioRepositorio.deleteAll();
    }

    @Test
    void GiveUsuario_WhenCreate_ThenUsuarioIdIsSaved(){
        //Give
        Usuario usuario=new Usuario() {
            @Override
            public void setId(Long id) {
                super.setId(1L);
            }

            @Override
            public void setPrimerNombre(String primerNombre) {
                super.setPrimerNombre("Andres");
            }

            @Override
            public void setSegundoNombre(String segundoNombre) {
                super.setSegundoNombre("Pedro");
            }

            @Override
            public void setPrimerApellido(String primerApellido) {
                super.setPrimerApellido("Parra");
            }

            @Override
            public void setSegundoApellido(String segundoApellido) {
                super.setSegundoApellido("Arias");
            }

            @Override
            public void setEmail(String email) {
                super.setEmail("Parrouianos_turulingo@gmail.com");
            }

            @Override
            public void setNumeroTelefono(Long numeroTelefono) {
                super.setNumeroTelefono(3005679876L);
            }

            @Override
            public void setSexo(String sexo) {
                super.setSexo("Masculino");
            }

            @Override
            public void setContraseña(String contraseña) {
                super.setContraseña("ÑioclaSala1234");
            }

            @Override
            public void setNombreUsuario(String nombreUsuario) {
                super.setNombreUsuario("Guillermito");
            }

            @Override
            public void setFechaRegistro(LocalDateTime fechaRegistro) {
                super.setFechaRegistro(LocalDateTime.of(2024, Month.AUGUST,10,8,20));
            }

            @Override
            public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
                super.setFechaNacimiento(LocalDateTime.of(2002, Month.APRIL,1,8,20));
            }

            @Override
            public void setRolUser(Rol rolUser) {
                super.setRolUser(Rol.ALUMNO);
            }

            @Override
            public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
                super.setEstadoUsuario(EstadoUsuario.ACTIVO);
            }
        };
        Usuario usuarioSaved = usuarioRepositorio.save(usuario);
        //when
        Optional<Usuario> optionalUsuario=usuarioRepositorio.findById(usuarioSaved.getId());
        //Then
        assertTrue(optionalUsuario.isPresent());
    }

}
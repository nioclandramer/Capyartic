package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.Entidades.Rol;
import com.Capyapp.Capyartic.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByRolUser(Rol rolUsuario);
    Optional<Usuario>findByEmail(String email);
}

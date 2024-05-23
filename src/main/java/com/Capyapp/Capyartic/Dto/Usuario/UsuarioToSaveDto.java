package com.Capyapp.Capyartic.Dto.Usuario;

import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;

import java.time.LocalDateTime;

public record UsuarioToSaveDto(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
                               String email, Integer numeroTelefono, String sexo, String contraseña, String nombreUsuario,
                               LocalDateTime fechaRegistro, LocalDateTime fechaNacimiento, Rol rolUser, EstadoUsuario estadoUsuario) {
}

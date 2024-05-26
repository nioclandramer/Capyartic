package com.Capyapp.Capyartic.Dto.Usuario;

import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public abstract class UsuarioToSaveDto  {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private Integer numeroTelefono;
    private String sexo;
    private String contraseña;
    private String nombreUsuario;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaNacimiento;
    private Rol rolUser;
    private EstadoUsuario estadoUsuario;
}

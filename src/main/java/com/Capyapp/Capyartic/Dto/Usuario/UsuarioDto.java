package com.Capyapp.Capyartic.Dto.Usuario;

import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private Long numeroTelefono;
    private String sexo;
    private String nombreUsuario;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaNacimiento;
    private Rol rolUser;
    private EstadoUsuario estadoUsuario;
    private String contrasena;
}

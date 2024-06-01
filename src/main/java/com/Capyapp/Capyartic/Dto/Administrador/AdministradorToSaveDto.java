package com.Capyapp.Capyartic.Dto.Administrador;


import com.Capyapp.Capyartic.Entidades.EstadoUsuario;
import com.Capyapp.Capyartic.Entidades.Rol;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdministradorToSaveDto {
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

    public AdministradorToSaveDto(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String email, Long numeroTelefono, String sexo, String nombreUsuario, LocalDateTime fechaRegistro, LocalDateTime fechaNacimiento, Rol rolUser, EstadoUsuario estadoUsuario) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.sexo = sexo;
        this.nombreUsuario = nombreUsuario;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
        this.rolUser = rolUser;
        this.estadoUsuario = estadoUsuario;
    }
}

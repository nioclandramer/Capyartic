package com.Capyapp.Capyartic.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String primerNombre;
    private String segundoNombre;
    @Column(nullable = false)
    private String primerApellido;
    private String segundoApellido;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = true)
    private Integer numeroTelefono;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private String contraseña;
    @Column(nullable = false)
    private String nombreUsuario;
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;
    @Column(nullable = false)
    private LocalDateTime fechaNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rolUser;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoUsuario estadoUsuario;

}

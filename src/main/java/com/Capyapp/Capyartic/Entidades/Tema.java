package com.Capyapp.Capyartic.Entidades;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "categoriaId", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "tema")
    private List<Sesion> sesiones;
}

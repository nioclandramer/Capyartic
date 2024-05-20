package com.Capyapp.Capyartic.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = true)
    private String descripcion;
    @OneToMany(mappedBy = "categoria")
    private List<Tutoria> tutorias;
    @ManyToMany(mappedBy = "categorias")
    private List<Tutor> tutores;
    @OneToMany(mappedBy = "categoria")
    private List<Tema> temas;
}

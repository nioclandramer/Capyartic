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
public class Tutor extends Usuario{
    @Column(nullable = true)
    private String tituloProfesional;

    @OneToMany(mappedBy = "tutor")
    private List<Tutoria> tutorias;

    @ManyToMany
    @JoinTable(
            name = "CategoriasTutor",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;
}

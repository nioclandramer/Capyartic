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
    @OneToMany(mappedBy = "tutor")
    private List<Solicitud> solicitud;
    @ManyToMany
    @JoinTable(
            name = "CategoriasTutores",
            joinColumns = @JoinColumn(name = "TutorId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "CategoriaId", referencedColumnName = "id")
    )
    private List<Categoria> categorias;

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
}

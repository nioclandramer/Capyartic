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
    // Methods to manage bidirectional relationships
    public void addTutoria(Tutoria tutoria) {
        tutorias.add(tutoria);
        tutoria.setCategoria(this);
    }

    public void removeTutoria(Tutoria tutoria) {
        tutorias.remove(tutoria);
        tutoria.setCategoria(null);
    }

    public void addTutor(Tutor tutor) {
        tutores.add(tutor);
        tutor.getCategorias().add(this);
    }

    public void removeTutor(Tutor tutor) {
        tutores.remove(tutor);
        tutor.getCategorias().remove(this);
    }

    public void addTema(Tema tema) {
        temas.add(tema);
        tema.setCategoria(this);
    }

    public void removeTema(Tema tema) {
        temas.remove(tema);
        tema.setCategoria(null);
    }
}

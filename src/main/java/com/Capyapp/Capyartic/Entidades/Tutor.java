package com.Capyapp.Capyartic.Entidades;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tutors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false)
    @JoinColumn(name = "usuarioId",referencedColumnName = "id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "tutorCategoria",
            joinColumns = @JoinColumn(name = "tutorId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn( name = "categoriaId",referencedColumnName = "id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
}

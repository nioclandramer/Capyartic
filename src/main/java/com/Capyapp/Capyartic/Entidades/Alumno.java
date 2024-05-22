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
public class Alumno extends  Usuario{
    @ManyToOne
    @JoinColumn(name = "nivelEducativoId")
    private NivelEducativo NivelEducativo;

    @OneToMany(mappedBy = "alumno")
    private List<Tutoria> tutorias;

    @OneToMany(mappedBy = "alumno")
    private List<Solicitud> solicitud;
}

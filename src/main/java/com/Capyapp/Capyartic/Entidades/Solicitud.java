package com.Capyapp.Capyartic.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean estadoSolicitud;
    @ManyToOne
    @JoinColumn(name = "tutorId", nullable = false)
    private Tutor tutor;
    @ManyToOne
    @JoinColumn(name = "alumnoId", nullable = false)
    private Alumno alumno;
}

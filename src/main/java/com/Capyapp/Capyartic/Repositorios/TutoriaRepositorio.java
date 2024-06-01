package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.Entidades.Alumno;
import com.Capyapp.Capyartic.Entidades.EstadoTutoria;
import com.Capyapp.Capyartic.Entidades.Tutor;
import com.Capyapp.Capyartic.Entidades.Tutoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TutoriaRepositorio extends JpaRepository<Tutoria,Long> {

    // Método para encontrar todas las tutorías de un tutor
    List<Tutoria> findAllByTutor(Tutor tutor);

    List<Tutoria>  findAllByAlumno(Alumno alumno);

    // Método para encontrar todas las tutorías de un tutor y las tutorías con el estado "SOLICITADA"
    @Query("SELECT t FROM Tutoria t WHERE t.tutor = :tutor OR t.estadoTutoria = :estadoTutoria")
    List<Tutoria> findAllByTutorOrEstadoTutoria(@Param("tutor") Tutor tutor, @Param("estadoTutoria") EstadoTutoria estadoTutoria);

}

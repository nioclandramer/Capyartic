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
    List<Tutoria> findByTutor_Id(Long idTutor);
    List<Tutoria> findByAlumno_Id(Long idAlumno);


    List<Tutoria> findByTutor_IdAndEstadoTutoria(Long idTutor, EstadoTutoria estadoTutoria);
}

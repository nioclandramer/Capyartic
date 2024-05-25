package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.Entidades.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemaRepositorio extends JpaRepository<Tema,Long> {
    Tema findTemaByNombre(String nombre);

    // Método nuevo para encontrar temas con tutores activos
    @Query("SELECT DISTINCT tm FROM Tema tm " +
            "JOIN tm.categoria c " +
            "JOIN c.tutores t " +
            "WHERE t.estadoUsuario = 'ACTIVO'")
    List<Tema> findTemasWithActiveTutors();

}

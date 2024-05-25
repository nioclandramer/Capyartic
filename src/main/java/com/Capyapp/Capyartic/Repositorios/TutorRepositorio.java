package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.Entidades.Categoria;
import com.Capyapp.Capyartic.Entidades.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TutorRepositorio extends JpaRepository<Tutor,Long> {
    //Buscar tutores por categoria
    @Query("SELECT t FROM Tutor t JOIN t.categorias c WHERE c.nombre = :nombreCategoria")
    Optional<Tutor> findTutorsByCategoriaNombre(@Param("nombreCategoria") String nombreCategoria);
    // buscar tutor por tema
    @Query("SELECT DISTINCT t FROM Tutor t " +
            "JOIN t.categorias c " +
            "JOIN c.temas tm " +
            "WHERE tm.nombre = :nombreTema")
    Optional<Tutor> findTutorsByTemaNombre(@Param("nombreTema") String nombreTema);

    @Query("SELECT t FROM Tutor t JOIN t.categorias c " +
            "WHERE c.nombre = :nombreCategoria AND t.estadoUsuario = 'ACTIVO'")
    List<Tutor> findTutorsByCategoriaNombreAndEstadoActivo(@Param("nombreCategoria") String nombreCategoria);
}

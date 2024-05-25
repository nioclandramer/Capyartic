package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
    @Query("SELECT DISTINCT c FROM Categoria c " +
            "JOIN c.tutores t " +
            "WHERE t.estadoUsuario = 'ACTIVO'")
    List<Categoria> findCategoriasWithActiveTutors();
}


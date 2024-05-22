package com.Capyapp.Capyartic.Repositorios;

import com.Capyapp.Capyartic.Entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepositorio extends JpaRepository<Solicitud,Long> {
    List<Solicitud> findSolicitudByTutorId(Long id);
}

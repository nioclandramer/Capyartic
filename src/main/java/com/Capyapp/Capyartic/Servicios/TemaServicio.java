package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Dto.Tema.TemaToSaveDto;

import java.util.List;

public interface TemaServicio {
    TemaDto guardarTema(TemaToSaveDto tema);
    TemaDto actualizarTema(Long id,TemaToSaveDto tema);
    TemaDto findTemaById(Long id);
    List<TemaDto> findAllTema();
    void eliminarTema(Long id);
}

package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Dto.Tema.TemaToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.TemaNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TemaServicio {
    TemaDto guardarTema(TemaToSaveDto tema);
    TemaDto actualizarTema(Long id,TemaToSaveDto tema);
    TemaDto findTemaById(Long id)throws TemaNotFoundException;
    Optional<List<TemaDto>> findAllTema();
    void eliminarTema(Long id)throws TemaNotFoundException;
}

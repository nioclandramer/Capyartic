package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.NivelEducativoNotFoundException;

import java.util.List;
import java.util.Optional;

public interface NivelEducativoServicio {
    NivelEducativoDto guardarNivelEducativo(NivelEducativoToSaveDto nivelEducativo);
    NivelEducativoDto actulizarNivelEducativo(Long id,NivelEducativoToSaveDto nivelEducativo);
    NivelEducativoDto findNivelEducativo(Long id) throws NivelEducativoNotFoundException;
    void deleteNivelEducativo(Long id) throws  NivelEducativoNotFoundException;
    Optional<List<NivelEducativoDto>> findAllNivelEducativo();
}

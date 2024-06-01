package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoToSaveDto;

import java.util.List;

public interface NivelEducativoServicio {
    NivelEducativoDto guardarNivelEducativo(NivelEducativoToSaveDto nivelEducativo);
    NivelEducativoDto actulizarNivelEducativo(Long id,NivelEducativoToSaveDto nivelEducativo);
    NivelEducativoDto findNivelEducativo(Long id);
    void deleteNivelEducativo(Long id);
    List<NivelEducativoDto> findAllNivelEducativo();
}

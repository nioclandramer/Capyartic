package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoDto;
import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoMapper;
import com.Capyapp.Capyartic.Dto.NivelEducativo.NivelEducativoToSaveDto;
import com.Capyapp.Capyartic.Entidades.NivelEducativo;
import com.Capyapp.Capyartic.Excepciónes.NivelEducativoNotFoundException;
import com.Capyapp.Capyartic.Repositorios.NivelEducativoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NivelEducativoServicioIMPL implements NivelEducativoServicio{
    private final NivelEducativoRepositorio nivelEducativoRepositorio;

    public NivelEducativoServicioIMPL(NivelEducativoRepositorio nivelEducativoRepositorio) {
        this.nivelEducativoRepositorio = nivelEducativoRepositorio;
    }

    @Override
    public NivelEducativoDto guardarNivelEducativo(NivelEducativoToSaveDto nivelEducativo) {
        NivelEducativo nivelEducativo1= NivelEducativoMapper.INSTANCE.toSaveDtoToNivelEducativo(nivelEducativo);
        NivelEducativo nivelEducativoGuardado= nivelEducativoRepositorio.save(nivelEducativo1);

        return NivelEducativoMapper.INSTANCE.nivelEducativoToDto(nivelEducativoGuardado);
    }

    @Override
    public NivelEducativoDto actulizarNivelEducativo(Long id, NivelEducativoToSaveDto nivelEducativo) {
        NivelEducativo nivelEducativo1= NivelEducativoMapper.INSTANCE.toSaveDtoToNivelEducativo(nivelEducativo);
        NivelEducativo nivelEducativoExiste= nivelEducativoRepositorio.findById(id).orElseThrow(()->new NivelEducativoNotFoundException("Nivel educativo no existe"));
        nivelEducativoExiste.setNombre(nivelEducativo1.getNombre());
        nivelEducativoExiste=nivelEducativoRepositorio.save(nivelEducativoExiste);

        return NivelEducativoMapper.INSTANCE.nivelEducativoToDto(nivelEducativoExiste);
    }

    @Override
    public NivelEducativoDto findNivelEducativo(Long id) throws NivelEducativoNotFoundException {
        NivelEducativo nivelEducativo= nivelEducativoRepositorio.findById(id).orElseThrow(()->new NivelEducativoNotFoundException("Nivel educativo no existe"));

        return NivelEducativoMapper.INSTANCE.nivelEducativoToDto(nivelEducativo);
    }

    @Override
    public void deleteNivelEducativo(Long id) throws NivelEducativoNotFoundException {
        NivelEducativo nivelEducativo= nivelEducativoRepositorio.findById(id).orElseThrow(()->new NivelEducativoNotFoundException("Nivel educativo no existe"));
        nivelEducativoRepositorio.delete(nivelEducativo);
    }

    @Override
    public Optional<List<NivelEducativoDto>> findAllNivelEducativo() {
        List<NivelEducativo> nivelEducativos=nivelEducativoRepositorio.findAll();
        List<NivelEducativoDto> nivelEducativoDtos=nivelEducativos.stream().map(NivelEducativoMapper.INSTANCE::nivelEducativoToDto).collect(Collectors.toList());

        return Optional.of(nivelEducativoDtos);
    }
}

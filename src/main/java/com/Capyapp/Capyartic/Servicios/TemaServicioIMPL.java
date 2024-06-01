package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Tema.TemaDto;
import com.Capyapp.Capyartic.Dto.Tema.TemaMapper;
import com.Capyapp.Capyartic.Dto.Tema.TemaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Tema;
import com.Capyapp.Capyartic.Excepciónes.TemaNotFoundException;
import com.Capyapp.Capyartic.Repositorios.TemaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TemaServicioIMPL implements TemaServicio{
    private final TemaRepositorio temaRepositorio;

    public TemaServicioIMPL(TemaRepositorio temaRepositorio) {
        this.temaRepositorio = temaRepositorio;
    }

    @Override
    public TemaDto guardarTema(TemaToSaveDto tema) {
        Tema tema1= TemaMapper.INSTANCE.temaToSaveDtoToTema(tema);
        Tema temaGuardado= temaRepositorio.save(tema1);
        return TemaMapper.INSTANCE.temaToTemaDto(temaGuardado);
    }

    @Override
    public TemaDto actualizarTema(Long id,TemaToSaveDto tema) {
        Tema tema1=TemaMapper.INSTANCE.temaToSaveDtoToTema(tema);
        Tema temaExistente= temaRepositorio.findById(id).orElseThrow(()->new TemaNotFoundException("Tema no encontrado"));
        temaExistente.setDescripcion(tema1.getDescripcion());
        temaExistente.setNombre(tema1.getNombre());
        temaExistente.setCategoria(tema1.getCategoria());
        temaExistente=temaRepositorio.save(temaExistente);
        return TemaMapper.INSTANCE.temaToTemaDto(temaExistente);
    }

    @Override
    public TemaDto findTemaById(Long id)throws TemaNotFoundException {
        Tema  tema= temaRepositorio.findById(id).orElseThrow(()->new TemaNotFoundException("Tema no encontrado"));

        return TemaMapper.INSTANCE.temaToTemaDto(tema);
    }

    @Override
    public Optional<List<TemaDto>> findAllTema() {
        List<Tema> temas= temaRepositorio.findAll();
        List<TemaDto> temaDtos=temas.stream().map(TemaMapper.INSTANCE::temaToTemaDto).collect(Collectors.toList());
        return Optional.of(temaDtos);
    }

    @Override
    public void eliminarTema(Long id) throws TemaNotFoundException {
        Tema tema= temaRepositorio.findById(id).orElseThrow(()->new TemaNotFoundException("Tema no encontrado"));
        temaRepositorio.delete(tema);
    }
}

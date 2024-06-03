package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Categoria.CategoriaToSaveDto;
import com.Capyapp.Capyartic.Excepciónes.CategoriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategoriaServicio {
    CategoriaDto guardarCategoria(CategoriaToSaveDto categoria);
    CategoriaDto actualizarCategoria(Long id,CategoriaToSaveDto categoria);
    CategoriaDto findById(Long id)throws CategoriaNotFoundException;
    void deleteById(Long id)throws CategoriaNotFoundException;
    Optional<List<CategoriaDto>> getAllCategorias();
    Optional<List<CategoriaDto>> categoriasConTutoresAct();
}

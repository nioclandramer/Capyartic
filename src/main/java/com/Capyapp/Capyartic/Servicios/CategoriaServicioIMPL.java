package com.Capyapp.Capyartic.Servicios;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Categoria.CategoriaMapper;
import com.Capyapp.Capyartic.Dto.Categoria.CategoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Categoria;
import com.Capyapp.Capyartic.Excepciónes.CategoriaNotFoundException;
import com.Capyapp.Capyartic.Repositorios.CategoriaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicioIMPL implements  CategoriaServicio  {
    private final CategoriaRepositorio categoriaRepositorio;

    public CategoriaServicioIMPL(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public CategoriaDto guardarCategoria(CategoriaToSaveDto categoria) {
        Categoria categoria1= CategoriaMapper.INSTANCE.CategoriaToSaveDtoToCategoria(categoria);
        Categoria categoriaGuardada= categoriaRepositorio.save(categoria1);
        return CategoriaMapper.INSTANCE.categoriaToCategoriaDto(categoriaGuardada);
    }

    @Override
    public CategoriaDto actualizarCategoria(Long id, CategoriaToSaveDto categoria) {
        Categoria categoria1=CategoriaMapper.INSTANCE.CategoriaToSaveDtoToCategoria(categoria);
        Categoria categoriaExiste=categoriaRepositorio.findById(id).orElseThrow(()-> new CategoriaNotFoundException("Categoría no existe"));
        categoriaExiste.setDescripcion(categoria1.getDescripcion());
        categoriaExiste.setNombre(categoria1.getNombre());
        return CategoriaMapper.INSTANCE.categoriaToCategoriaDto(categoriaExiste);
    }

    @Override
    public CategoriaDto findById(Long id) throws CategoriaNotFoundException {
        Categoria categoria= categoriaRepositorio.findById(id).orElseThrow(()-> new CategoriaNotFoundException("Categoria no existe"));
        return CategoriaMapper.INSTANCE.categoriaToCategoriaDto(categoria);
    }

    @Override
    public void deleteById(Long id) throws CategoriaNotFoundException {
        Categoria categoria= categoriaRepositorio.findById(id).orElseThrow(()-> new CategoriaNotFoundException("Categoria no existe"));
        categoriaRepositorio.deleteById(id);
    }
}

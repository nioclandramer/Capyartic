package com.Capyapp.Capyartic.Api;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;
import com.Capyapp.Capyartic.Dto.Categoria.CategoriaToSaveDto;
import com.Capyapp.Capyartic.Entidades.Categoria;
import com.Capyapp.Capyartic.Servicios.CategoriaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaControlador {
    private final CategoriaServicio categoriaServicio;

    public CategoriaControlador(CategoriaServicio categoriaServicio) {
        this.categoriaServicio=categoriaServicio;
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CategoriaToSaveDto categoria) {
        categoriaServicio.guardarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,@RequestBody CategoriaToSaveDto categoria) {
        categoriaServicio.actualizarCategoria(id, categoria);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<Optional<List<CategoriaDto>>> getAll() {
        Optional<List<CategoriaDto>> categorias=categoriaServicio.getAllCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/activas")
    public ResponseEntity<Optional<List<CategoriaDto>>> getCategoriasActivas() {
        Optional<List<CategoriaDto>> categorias=categoriaServicio.categoriasConTutoresAct();
        return ResponseEntity.ok().body(categorias);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoriaServicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

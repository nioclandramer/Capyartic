package com.Capyapp.Capyartic.Dto.Tema;

import com.Capyapp.Capyartic.Dto.Categoria.CategoriaDto;

public record TemaToSaveDto(String nombre, String descripcion, CategoriaDto categoriaDto) {
}

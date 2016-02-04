package com.wpsnetwork.dto;

import com.wpsnetwork.dao.memoria.RepositorioCategoriasLibrosMemoriaDao;
import com.wpsnetwork.dto.entidades.CategoriaLibro;

public class CategoriasLibrosDto extends Dto<RepositorioCategoriasLibrosMemoriaDao,CategoriaLibro,com.wpsnetwork.dao.entidades.CategoriaLibro> {

	public CategoriasLibrosDto() { super( new RepositorioCategoriasLibrosMemoriaDao(),new CategoriaLibro()); }
}

package com.wpsnetwork.dto;

import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.interfaces.Dao;

public final class CategoriasLibrosDto extends Dto<CategoriaLibro> {
	public CategoriasLibrosDto( Dao<CategoriaLibro> repositorio ) {
		super( repositorio );
	}
}
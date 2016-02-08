package com.wpsnetwork.dto;

import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.interfaces.Dao;

public final class LibrosDto extends Dto<Libro> {
	public LibrosDto( Dao<Libro> repositorio ) {
		super( repositorio );
	}
}
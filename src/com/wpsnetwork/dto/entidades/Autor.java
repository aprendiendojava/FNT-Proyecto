package com.wpsnetwork.dto.entidades;

import java.util.List;

public class Autor extends EntidadDto<com.wpsnetwork.dao.entidades.Autor> {
	private List<Libro> libros;
	public Autor() {};
	public Autor( String nombre ) {
		setEntidad(new com.wpsnetwork.dao.entidades.Autor( nombre ));
	}
}

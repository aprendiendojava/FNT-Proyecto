package com.wpsnetwork.dao.entidades;

import javax.persistence.Entity;

@Entity
public final class Autor extends EntidadRelacionalIndexada {
	private String nombre;

	static {
		addRelation( Libro.class, LibroNNAutor.class );
	}

	public Autor( String nombre ) {
		this.nombre = nombre;
	}
}

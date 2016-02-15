package com.wpsnetwork.dao.entidades;

import javax.persistence.Entity;

@Entity
public final class CategoriaLibro extends EntidadIndexada {
	private String nombre;

	public CategoriaLibro( String nombre ) {
		this.nombre = nombre;
	}
}

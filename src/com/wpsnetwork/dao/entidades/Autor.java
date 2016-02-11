package com.wpsnetwork.dao.entidades;

import javax.persistence.Entity;

@Entity
public final class Autor extends EntidadIndexada {
	private String nombre;

	public Autor( String nombre ) {
		this.nombre = nombre;
	}
}

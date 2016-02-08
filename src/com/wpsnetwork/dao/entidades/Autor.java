package com.wpsnetwork.dao.entidades;

public final class Autor extends EntidadIndexada {
	private String nombre;

	public Autor( String nombre ) {
		this.nombre = nombre;
	}

	public String toString() {
		return getId() + " : Nombre:" + nombre;
	}
}

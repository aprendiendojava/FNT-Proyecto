package com.wpsnetwork.dao.entidades;

public final class CategoriaLibro extends EntidadIndexada {
	private static int sequence = 0;
	private String nombre;

	public CategoriaLibro( String nombre ) {
		this.id = sequence++;
		this.nombre = nombre;
	}
}

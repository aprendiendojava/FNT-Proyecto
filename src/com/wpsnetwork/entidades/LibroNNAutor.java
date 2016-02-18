package com.wpsnetwork.entidades;

public final class LibroNNAutor extends CEntidadIndexada {
	private int idAutor;
	private int idLibro;

	public LibroNNAutor( int idAutor, int idLibro ) {
		this.idAutor = idAutor;
		this.idLibro = idLibro;
	}
}

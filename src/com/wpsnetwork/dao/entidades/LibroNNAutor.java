package com.wpsnetwork.dao.entidades;

public final class LibroNNAutor extends EntidadIndexada {
	private int idAutor;
	private int idLibro;

	public LibroNNAutor( int idAutor, int idLibro ) {
		this.idAutor = idAutor;
		this.idLibro = idLibro;
	}
}

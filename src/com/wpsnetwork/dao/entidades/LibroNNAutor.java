package com.wpsnetwork.dao.entidades;

public final class LibroNNAutor extends EntidadIndexada {
	private static int sequence = 0;
	private int idAutor, idLibro;

	public LibroNNAutor( int idAutor, int idLibro ) {
		this.id = sequence++;
		this.idAutor = idAutor;
		this.idLibro = idLibro;
	}
}

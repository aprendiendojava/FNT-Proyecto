package com.wpsnetwork.dao.entidades;

public final class LibroNNAutor extends EntidadIndexada {
	private int idAutor, idLibro;

	public LibroNNAutor( int idAutor, int idLibro ) {
		this.idAutor = idAutor;
		this.idLibro = idLibro;
	}

	public String toString() {
		return getId() + " : Libro:" + idLibro + ", Autor:"+ idAutor;
	}
}

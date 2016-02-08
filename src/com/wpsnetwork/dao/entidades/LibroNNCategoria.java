package com.wpsnetwork.dao.entidades;

public final class LibroNNCategoria extends EntidadIndexada {
	private int idLibro, idCategoriaLibro;

	public LibroNNCategoria( int idLibro, int idCategoriaLibro ) {
		this.idLibro = idLibro;
		this.idCategoriaLibro = idCategoriaLibro;
	}

	public String toString() {
		return getId() + " : Libro:" + idLibro + ", Categoria:" + idCategoriaLibro;
	}
}

package com.wpsnetwork.dao.entidades;

public final class LibroNNCategoria extends EntidadIndexada {
	private int idLibro;
	private int idCategoriaLibro;

	public LibroNNCategoria( int idLibro, int idCategoriaLibro ) {
		this.idLibro = idLibro;
		this.idCategoriaLibro = idCategoriaLibro;
	}
}

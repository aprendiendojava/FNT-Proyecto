package com.wpsnetwork.entidades;

public final class LibroNNCategoria extends CEntidadIndexada {
	private int idLibro;
	private int idCategoriaLibro;

	public LibroNNCategoria( int idLibro, int idCategoriaLibro ) {
		this.idLibro = idLibro;
		this.idCategoriaLibro = idCategoriaLibro;
	}
}

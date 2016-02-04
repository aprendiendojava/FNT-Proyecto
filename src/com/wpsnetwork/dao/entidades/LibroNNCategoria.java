package com.wpsnetwork.dao.entidades;

public final class LibroNNCategoria extends EntidadIndexada {
	private static int sequence = 0;
	private int idLibro, idCategoriaLibro;

	public LibroNNCategoria( int idLibro, int idCategoriaLibro ) {
		this.id = sequence++;
		this.idLibro = idLibro;
		this.idCategoriaLibro = idCategoriaLibro;
	}
}

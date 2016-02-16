package com.wpsnetwork.dao.entidades;

public final class LibroNNAutor extends EntidadRelacionalIndexada {
	private int idAutor;
	private int idLibro;

	public LibroNNAutor( int idAutor, int idLibro ) {
		this.idAutor = idAutor;
		this.idLibro = idLibro;
	}

	@Override
	public Object getFk(Class<? extends EntidadRelacionalIndexada> relacion) {
		if( relacion == Autor.class ) return idAutor;
		else if ( relacion == Libro.class) return idLibro;
		else throw new RuntimeException();
	}
}

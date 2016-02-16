package com.wpsnetwork.dao.entidades;

import javax.persistence.Entity;

@Entity
public final class Libro extends EntidadRelacionalIndexada {
	private String titulo;
	private int    paginas;
	private String editorial;
	private int    edicion;

	static {
		addRelation( Autor.class, LibroNNAutor.class );
	}

	public Libro( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}
}

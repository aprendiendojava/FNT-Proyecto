package com.wpsnetwork.datos.entidades;

import javax.persistence.Entity;

@Entity
public class LibroDto extends com.wpsnetwork.entidades.Libro {
	public LibroDto( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}
}

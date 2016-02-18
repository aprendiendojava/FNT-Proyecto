package com.wpsnetwork.datos.entidades;

public class Libro extends com.wpsnetwork.entidades.Libro implements EntidadIndexada {
	public Libro( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	@Override
	public Object getIndex() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}

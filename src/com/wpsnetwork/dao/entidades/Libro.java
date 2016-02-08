package com.wpsnetwork.dao.entidades;

public final class Libro extends EntidadIndexada {
	private String titulo;
	private int    paginas;
	private String editorial;
	private int    edicion;

	public Libro( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public String toString() {
		return getId() + " : T�tulo:" + titulo
				+ ", P�ginas:" + paginas
				+ ", Editorial:" + editorial
				+ ", Edici�n:" + edicion;
	}
}

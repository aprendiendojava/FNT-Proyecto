package com.wpsnetwork.dao.entidades;

public final class Libro extends EntidadIndexada {
	private static int sequence = 0;
	private String titulo;
	private int    paginas;
	private String editorial;
	private int    edicion;

	public Libro( String titulo ) {
		this.id = this.sequence++;
		this.titulo = titulo;
	}

	public String toString() {
		return id + " : " + titulo;
	}
}

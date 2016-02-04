package com.wpsnetwork.dao.entidades;

public final class Autor extends EntidadIndexada {
	private static int sequence = 0;
	private String nombre;

	public Autor( String nombre ) {
		this.id = sequence++;
		this.nombre = nombre;
	}

	 public String toString() {
		 return id + ":" + nombre;
	 }
}

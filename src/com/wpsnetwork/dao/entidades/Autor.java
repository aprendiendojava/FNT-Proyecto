package com.wpsnetwork.dao.entidades;

import java.io.Serializable;

import com.google.gson.Gson;

public final class Autor extends EntidadIndexada implements Serializable {
	private String nombre;

	public Autor( String nombre ) {
		this.nombre = nombre;
	}

	public String toString() {
		return new Gson().toJson(this);
		//return getId() + " : Nombre:" + nombre;
	}
}

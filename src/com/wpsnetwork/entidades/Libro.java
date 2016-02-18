package com.wpsnetwork.entidades;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.model.entidad.EntidadIndexada;

@MappedSuperclass
public abstract class Libro extends EntidadIndexada {
	protected String titulo;
	protected int    paginas;
	protected String editorial;
	protected int    edicion;
}

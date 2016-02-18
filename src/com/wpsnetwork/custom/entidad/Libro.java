package com.wpsnetwork.custom.entidad;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entidad.EntidadIndexada;

@MappedSuperclass
public abstract class Libro extends EntidadIndexada {
	protected String titulo;
	protected int    paginas;
	protected String editorial;
	protected int    edicion;
}

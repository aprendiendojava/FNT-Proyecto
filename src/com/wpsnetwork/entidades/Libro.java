package com.wpsnetwork.entidades;

import javax.persistence.Entity;

@Entity
public abstract class Libro {
	protected Integer id;
	protected String titulo;
	protected int    paginas;
	protected String editorial;
	protected int    edicion;
}

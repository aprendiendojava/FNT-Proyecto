package com.wpsnetwork.custom.entity;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entity.Table;

@MappedSuperclass
public abstract class Libro extends Table {
	protected String titulo;
	protected int    paginas;
	protected String editorial;
	protected int    edicion;
}

package com.wpsnetwork.custom.entidad;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entity.Table;

@MappedSuperclass
public abstract class CategoriaLibro extends Table {
	protected String nombre;
}

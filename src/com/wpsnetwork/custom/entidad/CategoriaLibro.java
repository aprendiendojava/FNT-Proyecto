package com.wpsnetwork.custom.entidad;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entidad.EntidadIndexada;

@MappedSuperclass
public abstract class CategoriaLibro extends EntidadIndexada {
	protected String nombre;
}

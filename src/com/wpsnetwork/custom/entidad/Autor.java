package com.wpsnetwork.custom.entidad;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entidad.EntidadIndexada;

@MappedSuperclass
public abstract class Autor extends EntidadIndexada{
	protected String nombre;
}

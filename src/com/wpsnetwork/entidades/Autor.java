package com.wpsnetwork.entidades;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.model.entidad.EntidadIndexada;

@MappedSuperclass
public abstract class Autor extends EntidadIndexada{
	protected String nombre;
}

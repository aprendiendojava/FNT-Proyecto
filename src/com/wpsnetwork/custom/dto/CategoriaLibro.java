package com.wpsnetwork.custom.dto;

import javax.persistence.Entity;

@Entity
public class CategoriaLibro extends com.wpsnetwork.custom.entidad.CategoriaLibro {
	public CategoriaLibro( String nombre ) {
		this.nombre = nombre;
	}
}

package com.wpsnetwork.custom.dto;

import javax.persistence.Entity;

@Entity
public class CategoriaLibroDto extends com.wpsnetwork.custom.entidad.CategoriaLibro {
	public CategoriaLibroDto( String nombre ) {
		this.nombre = nombre;
	}
}

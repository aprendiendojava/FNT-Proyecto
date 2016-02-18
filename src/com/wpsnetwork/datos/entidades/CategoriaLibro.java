package com.wpsnetwork.datos.entidades;

public class CategoriaLibro extends com.wpsnetwork.entidades.CategoriaLibro implements EntidadIndexada {
	public CategoriaLibro( String nombre ) {
		this.nombre = nombre;
	}

	@Override
	public Object getIndex() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}

package com.wpsnetwork.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.Gson;
import com.wpsnetwork.dao.interfaces.Indexado;
import com.wpsnetwork.datos.entidades.EntidadIndexada;

public abstract class CEntidadIndexada implements Indexado, EntidadIndexada {
	@Id
	@GeneratedValue
	private Integer id;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	@Override
	public Object getIndex() {
		return id;
	}
}

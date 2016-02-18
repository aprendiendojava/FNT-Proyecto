package com.wpsnetwork.base.entidad;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.gson.Gson;
import com.wpsnetwork.base.interfaz.Indexado;

@MappedSuperclass
public abstract class EntidadIndexada implements Indexado {
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
	public Serializable getIndex() {
		return id;
	}
}

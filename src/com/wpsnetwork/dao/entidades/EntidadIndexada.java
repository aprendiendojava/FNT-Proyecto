package com.wpsnetwork.dao.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.gson.Gson;
import com.wpsnetwork.dao.interfaces.Indexado;

@MappedSuperclass
public abstract class EntidadIndexada implements Indexado {
	@Id
	@GeneratedValue
	private int id;

	@Override
    public final int getId() {
    	return id;
    }

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}

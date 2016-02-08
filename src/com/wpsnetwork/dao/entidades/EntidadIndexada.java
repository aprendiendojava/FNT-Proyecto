package com.wpsnetwork.dao.entidades;

import com.google.gson.Gson;
import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class EntidadIndexada implements Indexado {
	private int id;

	@Override
    public final int getId() {
    	return id;
    }

	public final void setId( int id ) {
		this.id = id;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}

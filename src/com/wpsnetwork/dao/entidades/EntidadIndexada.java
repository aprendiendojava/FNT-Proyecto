package com.wpsnetwork.dao.entidades;

import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class EntidadIndexada implements Indexado {
	protected int id;

	@Override
    public int getId() {
    	return id;
    }
}

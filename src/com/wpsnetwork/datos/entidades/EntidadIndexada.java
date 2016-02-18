package com.wpsnetwork.datos.entidades;

import com.wpsnetwork.dao.interfaces.Indexado;

public interface EntidadIndexada extends Indexado {
	@Override
	public Object getIndex();
	public void setId( Integer id );
}

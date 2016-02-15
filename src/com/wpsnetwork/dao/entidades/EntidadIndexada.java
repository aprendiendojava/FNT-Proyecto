package com.wpsnetwork.dao.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.Gson;
import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class EntidadIndexada implements Indexado {
	@Id
	@GeneratedValue
	private Integer id;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	protected void setId( Integer id ) {
		this.id = id;
	}

	@Override
	public Object getIndex() {
		return id;
	}


	public static <ENTIDAD extends EntidadIndexada> void setId( Integer id, ENTIDAD entidad ) {
		if ( entidad.getIndex() == null )
			entidad.setId(id);
		else
			throw new RuntimeException();
	}

}

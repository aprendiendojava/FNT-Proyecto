package com.wpsnetwork.dto.entidades;

import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class EntidadDto <ENTIDAD extends Indexado> implements Indexado {
	private ENTIDAD entidad;

	public ENTIDAD getEntidad() { return entidad; }
	public void setEntidad( ENTIDAD entidad ) { this.entidad = entidad; }

	@Override
	public int getId() {
		return entidad.getId();
	}
}

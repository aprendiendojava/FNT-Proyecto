package com.wpsnetwork.dto.entidades;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Indexado;

public class EntidadDto <ENTIDAD extends EntidadIndexada> implements Indexado {
	private ENTIDAD entidad;

	public EntidadDto( ENTIDAD entidad ) {
		setEntidad(entidad);
	}

	public ENTIDAD getEntidad() {
		return entidad;
	}

	private void setEntidad( ENTIDAD entidad ) {
		this.entidad = entidad;
	}

	public void updateEntidad( ENTIDAD entidad ) {
		entidad.setId(this.entidad.getId());
		this.entidad = entidad;
	}

	@Override
	public int getId() {
		return entidad.getId();
	}

	public String toString() {
		return " | DTO : " + entidad.toString();
	}
}

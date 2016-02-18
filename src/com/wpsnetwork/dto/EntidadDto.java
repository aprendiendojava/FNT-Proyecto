package com.wpsnetwork.dto;

import com.wpsnetwork.dao.interfaces.Indexado;
import com.wpsnetwork.datos.entidades.EntidadIndexada;

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
		// TODO Util.setId( this.entidad.getIndex(), entidad );
		this.entidad = entidad;
	}

	public String toString() {
		return " | DTO : " + entidad.toString();
	}

	@Override
	public Object getIndex() {
		return entidad.getIndex();
	}
}

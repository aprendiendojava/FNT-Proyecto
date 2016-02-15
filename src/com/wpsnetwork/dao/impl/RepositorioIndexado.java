package com.wpsnetwork.dao.impl;

import java.util.Observable;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.DaoIndexado;

public abstract class RepositorioIndexado<ENTIDAD extends EntidadIndexada> extends Observable implements DaoIndexado<ENTIDAD> {
	private final Class<ENTIDAD> claseRepositorio;
	private int sequence = 1;

	protected void assignId( ENTIDAD entidad ) {
		EntidadIndexada.setId( sequence++, entidad );
	}

	public RepositorioIndexado( Class<ENTIDAD> claseEntidad ) {
		this.claseRepositorio = claseEntidad;
	}

	protected Class<ENTIDAD> getClaseRepositorio() {
		return claseRepositorio;
	}

	protected void repositoryChanged( Object object ) {
		setChanged();
		notifyObservers( object );
	}
}

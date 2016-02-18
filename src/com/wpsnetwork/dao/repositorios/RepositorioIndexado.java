package com.wpsnetwork.dao.repositorios;

import java.util.Observable;

import com.wpsnetwork.dao.interfaces.DaoIndexado;
import com.wpsnetwork.datos.entidades.EntidadIndexada;

public abstract class RepositorioIndexado<ENTIDAD extends EntidadIndexada> extends Observable implements DaoIndexado<ENTIDAD> {
	private final Class<ENTIDAD> claseRepositorio;
	private int sequence = 1;

	protected void assignId( ENTIDAD entidad ) {
		entidad.setId( sequence++ );
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

package com.wpsnetwork.dao;

import java.util.Observable;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class RepositorioGenerico<ENTIDAD extends Indexado> extends Observable implements Dao<ENTIDAD> {
	private final Class<ENTIDAD> claseRepositorio;

	public RepositorioGenerico( Class<ENTIDAD> claseEntidad ) {
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

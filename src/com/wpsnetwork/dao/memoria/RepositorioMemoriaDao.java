package com.wpsnetwork.dao.memoria;

import java.util.List;
import java.util.Observable;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class RepositorioMemoriaDao<ENTIDAD extends Indexado> extends Observable implements Dao<ENTIDAD> {
	private List<ENTIDAD> datosEnMemoria;

	protected RepositorioMemoriaDao( List<ENTIDAD> datosEnMemoria ) {
		this.datosEnMemoria = datosEnMemoria;
	}

	public ENTIDAD get( int id ) {
		return datosEnMemoria.stream().filter( elm -> elm.getId() == id ).findAny().get();
	}

	public void insert( ENTIDAD object ) {
		datosEnMemoria.add( object );
		setChanged();
		notifyObservers();
	}

	public void update( ENTIDAD object ) {
		delete( object );
		datosEnMemoria.add( object );
		setChanged();
		notifyObservers();
	}

	public void delete( ENTIDAD object ) {
		datosEnMemoria.remove( get( object.getId()));
		setChanged();
		notifyObservers();
	}

	public List<ENTIDAD> getAll() {
		return datosEnMemoria;
	}
}
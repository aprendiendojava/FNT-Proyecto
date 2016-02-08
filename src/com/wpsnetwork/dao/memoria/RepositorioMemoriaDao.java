package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Dao;

public class RepositorioMemoriaDao<ENTIDAD extends EntidadIndexada> extends Observable implements Dao<ENTIDAD> {
	private static final Logger logDao = LogManager.getLogger( RepositorioMemoriaDao.class );
	private int sequence = 1;
	private Map<Object,ENTIDAD> datosEnMemoria = new HashMap<>();

	public RepositorioMemoriaDao() {
		this( new ArrayList<ENTIDAD>());
	}

	protected RepositorioMemoriaDao( List<ENTIDAD> datosEnMemoria ) {
		StringBuilder t = new StringBuilder( this.getClass().getName());

		datosEnMemoria.stream()
			.forEach(
				entidad -> {
					entidad.setId(sequence++);
					this.datosEnMemoria.put(entidad.getId(), entidad);
					t.append( " # " ).append( entidad.getClass().getTypeName()).append( ": " ).append( entidad );
				}
			);
		logDao.trace(t);
	}

	public ENTIDAD get( int id ) {
		return datosEnMemoria.get(id);
	}

	public void insert( ENTIDAD object ) {
		object.setId(sequence++);
		logDao.trace( object.getClass().getTypeName() + ": " + object );
		datosEnMemoria.put( object.getId(), object );

		setChanged();
		notifyObservers(object);
	}

	public void update( ENTIDAD object ) {
		ENTIDAD before = datosEnMemoria.put(object.getId(), object );
		logDao.trace( " # BEFORE: # " + before.getClass().getTypeName() + ": " + before
					+ " # AFTER: # " + object.getClass().getTypeName() + ": " + object );

		setChanged();
		notifyObservers(object);
	}

	public void delete( ENTIDAD object ) {
		datosEnMemoria.remove( object.getId());
		logDao.trace( object.getClass().getTypeName() + ": " + object );

		setChanged();
		notifyObservers(object);
	}

	public List<ENTIDAD> getAll() {
		return new ArrayList<ENTIDAD>(datosEnMemoria.values());
	}
}
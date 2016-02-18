package com.wpsnetwork.dao.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.datos.entidades.EntidadIndexada;

public class RepositorioMemoriaDao<ENTIDAD extends EntidadIndexada> extends RepositorioIndexado<ENTIDAD> {
	private static final Logger logDao = LogManager.getLogger( RepositorioMemoriaDao.class );
	private Map<Object,ENTIDAD> datosEnMemoria = new HashMap<>();

	public RepositorioMemoriaDao( Class<ENTIDAD> claseEntidad ) {
		super( claseEntidad );
	}

	protected RepositorioMemoriaDao( List<ENTIDAD> datosEnMemoria ) {
		super(null);
		StringBuilder t = new StringBuilder( this.getClass().getName());

		datosEnMemoria.stream()
			.forEach(
				entidad -> {
					assignId(entidad);
					this.datosEnMemoria.put(entidad.getIndex(), entidad);
					t.append( " # " ).append( entidad.getClass().getTypeName()).append( ": " ).append( entidad );
				}
			);
		logDao.trace(t);
	}

	public ENTIDAD get( Serializable id ) {
		return datosEnMemoria.get(id);
	}

	public void insert( ENTIDAD object ) {
		assignId(object);

		logDao.trace( object.getClass().getTypeName() + ": " + object );
		datosEnMemoria.put( object.getIndex(), object );

		setChanged();
		notifyObservers(object);
	}

	public void update( ENTIDAD object ) {
		ENTIDAD before = datosEnMemoria.put( object.getIndex(), object );
		logDao.trace((( before==null )?"":" # BEFORE: # " + before.getClass().getTypeName() + ": " + before )
					+ " # AFTER: # " + object.getClass().getTypeName() + ": " + object );

		setChanged();
		notifyObservers(object);
	}

	public void delete( ENTIDAD object ) {
		datosEnMemoria.remove( object.getIndex());
		logDao.trace( object.getClass().getTypeName() + ": " + object );

		setChanged();
		notifyObservers(object);
	}

	public List<ENTIDAD> getAll() {
		return new ArrayList<ENTIDAD>(datosEnMemoria.values());
	}
}
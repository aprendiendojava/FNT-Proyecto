package com.wpsnetwork.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.interfaces.DaoIndexado;
import com.wpsnetwork.model.entidad.EntidadIndexada;

public class Dto<ENTIDAD extends EntidadIndexada> implements DaoIndexado<ENTIDAD>, Observer {
	private static final Logger logDto = LogManager.getLogger( Dto.class );
	private final DaoIndexado<ENTIDAD> repositorio;

	public <REPO extends DaoIndexado<ENTIDAD>> Dto( REPO repositorio ) {
		this.repositorio = repositorio;

		if ( repositorio instanceof Observable )
			((Observable)this.repositorio).addObserver( this );
	}

	@Override
	public ENTIDAD get( Serializable index ) {
		return repositorio.get(index);
	}

	@Override
	public void insert( ENTIDAD element ) {
		repositorio.insert( element );
	}

	@Override
	public void update( ENTIDAD original, ENTIDAD updated ) {
		repositorio.update( original, updated );
	}

	@Override
	public void delete( ENTIDAD element ) {
		repositorio.delete( element );
	}

	@Override
	public List<ENTIDAD> getAll() {
		List<ENTIDAD> entidades = repositorio.getAll();

		return entidades;		
	}

	@Override
	public void update(Observable o, Object arg) {
		logDto.trace(( o.getClass().getName() + " @ " + ( arg==null?"":( arg.getClass().getName() + ": " + arg ))));
	}
}

package com.wpsnetwork.dto;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dto.entidades.EntidadDto;

public class Dto<ENTIDAD extends EntidadIndexada> implements Dao<EntidadDto<ENTIDAD>>, Observer {
	private static final Logger logDto = LogManager.getLogger( Dto.class );
	private final Dao<ENTIDAD> repositorio;

	public <REPO extends Dao<ENTIDAD>> Dto( REPO repositorio ) {
		this.repositorio = (Dao<ENTIDAD>) repositorio;

		if ( repositorio instanceof Observable )
			((Observable)this.repositorio).addObserver( this );
	}

	@Override
	public EntidadDto<ENTIDAD> get( int id ) {
		EntidadDto<ENTIDAD> entDto = new EntidadDto<ENTIDAD>( repositorio.get(id));
		return entDto;
	}

	@Override
	public void insert( EntidadDto<ENTIDAD> element ) {
		repositorio.insert( element.getEntidad());
	}

	@Override
	public void update( EntidadDto<ENTIDAD> element ) {
		repositorio.update( element.getEntidad());
	}

	@Override
	public void delete( EntidadDto<ENTIDAD> element ) {
		repositorio.delete( element.getEntidad());
	}

	@Override
	public List<EntidadDto<ENTIDAD>> getAll() {
		List<ENTIDAD> entidades = repositorio.getAll();

		return entidades.stream().map( entidad -> {
			EntidadDto<ENTIDAD> entDto = new EntidadDto<ENTIDAD>( entidad );
			return entDto;
		}).collect(Collectors.toList());		
	}

	@Override
	public void update(Observable o, Object arg) {
		logDto.trace( o.getClass().getName() 
					+ " @ " + arg==null?"":( arg.getClass().getName() + ": " + arg )) ;
	}
}

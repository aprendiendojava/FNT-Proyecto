package com.wpsnetwork.base.repository;

import java.io.Serializable;
import java.util.List;

import com.wpsnetwork.base.entity.Indexed;

public interface Dao<ENTIDAD extends Indexed> {
	public void insert( ENTIDAD object );
	public ENTIDAD get( Serializable index );
	public void update( ENTIDAD original, ENTIDAD updated );
	public void delete( ENTIDAD object );
	public List<ENTIDAD> getAll();
}

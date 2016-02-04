package com.wpsnetwork.dao.interfaces;

import java.util.List;

public interface Dao<ENTIDAD extends Indexado> {
	public ENTIDAD get( int id );
	public void insert( ENTIDAD object );
	public void update( ENTIDAD object );
	public void delete( ENTIDAD object );
	public List<ENTIDAD> getAll();
}

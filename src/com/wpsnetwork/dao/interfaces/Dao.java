package com.wpsnetwork.dao.interfaces;

import java.util.List;

public interface Dao<ENTIDAD> {
	public void insert( ENTIDAD object );
	public void delete( ENTIDAD object );
	public List<ENTIDAD> getAll();
}

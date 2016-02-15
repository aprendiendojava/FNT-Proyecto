package com.wpsnetwork.dao.interfaces;

import java.io.Serializable;

public interface DaoIndexado<ENTIDAD extends Indexado> extends Dao<ENTIDAD> {
	public ENTIDAD get( Serializable index );
	public void update( ENTIDAD object );
	@Override
	public void delete( ENTIDAD object );
}

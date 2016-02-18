package com.wpsnetwork.base.interfaz;

import java.io.Serializable;

public interface DaoIndexado<ENTIDAD extends Indexado> extends Dao<ENTIDAD> {
	public ENTIDAD get( Serializable index );
	public void update( ENTIDAD original, ENTIDAD updated );
	@Override
	public void delete( ENTIDAD object );
}

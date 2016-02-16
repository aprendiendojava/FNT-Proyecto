package com.wpsnetwork.dao.entidades;

import java.util.HashMap;

public abstract class EntidadRelacionalIndexada extends EntidadIndexada {
	private static HashMap<Class<? extends EntidadRelacionalIndexada>,Class<? extends EntidadRelacionalIndexada>> relaciones;

	protected static <ERI extends EntidadRelacionalIndexada> void addRelation( Class<ERI> relacion ) {
		relaciones.put( relacion, relacion );
	}

	protected static void addRelation( Class<? extends EntidadRelacionalIndexada> relacion, Class<? extends EntidadRelacionalIndexada> relacionNM ) {
		relaciones.put( relacion, relacionNM );
	}

	public static <ERI extends EntidadRelacionalIndexada> Class<? extends EntidadRelacionalIndexada> getRelation( Class<ERI> relacion ) {
		return relaciones.get( relacion );
	}

	public Object getFk( Class<? extends EntidadRelacionalIndexada> relacion ) {
		if( relacion == this.getClass()) return this.getIndex();
		else throw new RuntimeException();
	};
}

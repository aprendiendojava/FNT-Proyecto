package com.wpsnetwork.dao.factorias;

import java.util.HashMap;
import java.util.Map;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Dao;

public class FactoriaDao {
	private static Map<RepoEntidad,Dao> repositorios = new HashMap<>();

	public static <E extends EntidadIndexada> Dao<E> getInstance( Class<? extends Dao> tipoRepositorio, Class<? extends EntidadIndexada> tipoEntidad )
	{
		RepoEntidad re = new RepoEntidad( tipoRepositorio, tipoEntidad );
		if ( repositorios.containsKey( re ))
			return repositorios.get( re );
		else {
			Dao<E> tmpRepositorio;
			try {
				tmpRepositorio = tipoRepositorio.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}

			repositorios.put( re, tmpRepositorio );
			return tmpRepositorio;
		}
	}

	private static class RepoEntidad {
		Class<? extends Dao> tipoRepositorio;
		Class<? extends EntidadIndexada> tipoEntidad;

		public RepoEntidad( Class<? extends Dao> tipoRepositorio, Class<? extends EntidadIndexada> tipoEntidad ) {
			this.tipoRepositorio = tipoRepositorio;
			this.tipoEntidad = tipoEntidad;
		}

		@Override
		public boolean equals( Object o ) {
			if ( o == this ) return true;
			if ( o == null ) return false;
			if (!( o instanceof RepoEntidad )) return false;
			RepoEntidad other = (RepoEntidad) o;
			return other.tipoEntidad.equals( this.tipoEntidad ) && other.tipoRepositorio.equals( this.tipoRepositorio );
		}
	}
}

package com.wpsnetwork.dao.factorias;

import java.util.HashMap;
import java.util.Map;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.memoria.RepositorioMemoriaDao;

public class FactoriaDao {
	private static Map<Class<? extends EntidadIndexada>,Dao> repositorios = new HashMap<>();

	public static <E extends EntidadIndexada> Dao<E> getInstance( Class<? extends Dao> tipoRepositorio, Class<? extends EntidadIndexada> tipoEntidad )
	{
		if ( repositorios.containsKey( tipoEntidad ))
			return repositorios.get( tipoEntidad );
		else {
			Dao<E> tmpRepositorio;
			try {
				tmpRepositorio = tipoRepositorio.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				tmpRepositorio = new RepositorioMemoriaDao<>();
			}

			repositorios.put( tipoEntidad, tmpRepositorio );
			return tmpRepositorio;
		}
	}
}

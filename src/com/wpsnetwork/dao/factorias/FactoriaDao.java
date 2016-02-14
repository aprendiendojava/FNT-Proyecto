package com.wpsnetwork.dao.factorias;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.fichero.RepositorioFicheroDao;
import com.wpsnetwork.dao.hibernate.RepositorioHibernateDao;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.memoria.RepositorioMemoriaDao;

public class FactoriaDao {
	private static Class<? extends Dao> defaultDao;
	private static Map<RepoEntidad,Dao> repositorios = new HashMap<>();
	private static Map<String,Class<? extends Dao>> repos = new HashMap<>();

	static {
		repos.put( "HIBERNATE", RepositorioHibernateDao.class );
		repos.put( "MEMORIA", RepositorioMemoriaDao.class );
		repos.put( "FICHERO", RepositorioFicheroDao.class );
		defaultDao = getDefaultDao();
	}

	private static Class<? extends Dao> getDefaultDao() {
		Properties configuracion = new Properties();
		try {
			configuracion.load(new FileReader( "src/com/wpsnetwork/aplicacion.properties" ));
			return repos.get( configuracion.getProperty("dao.acceso"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static <E extends EntidadIndexada> Dao<E> forEntity( Class<E> tipoEntidad ) {
		return getInstance( defaultDao, tipoEntidad );
	}

	public static <E extends EntidadIndexada> Dao<E> getInstance( String repositorio, Class<E> tipoEntidad ) {
		return getInstance( repos.get(repositorio), tipoEntidad );
	}

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

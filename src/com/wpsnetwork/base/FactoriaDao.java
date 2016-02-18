package com.wpsnetwork.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.wpsnetwork.base.entidad.EntidadIndexada;
import com.wpsnetwork.base.interfaz.Dao;
import com.wpsnetwork.base.interfaz.DaoIndexado;
import com.wpsnetwork.base.repositorio.RepositorioFicheroDao;
import com.wpsnetwork.base.repositorio.RepositorioHibernateDao;
import com.wpsnetwork.base.repositorio.RepositorioMemoriaDao;

public class FactoriaDao {
	private static Class<? extends DaoIndexado> defaultDao;
	private static Map<RepoEntidad,DaoIndexado> repositorios = new HashMap<>();
	private static Map<String,Class<? extends DaoIndexado>> repos = new HashMap<>();

	static {
		repos.put( "HIBERNATE", RepositorioHibernateDao.class );
		repos.put( "MEMORIA", RepositorioMemoriaDao.class );
		repos.put( "FICHERO", RepositorioFicheroDao.class );
		defaultDao = getDefaultDao();
	}

	private static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> Class<DAOE> getDefaultDao() {
		if(defaultDao != null) return (Class<DAOE>) defaultDao;

		Properties configuracion = new Properties();
		try {
			configuracion.load(new FileReader( "src/aplicacion.properties" ));
			return (Class<DAOE>) repos.get( configuracion.getProperty("dao.acceso"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> DAOE getRepositorio( RepoEntidad re ) {
		return (DAOE) repositorios.get(re);
	}
	private static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> Class<DAOE> getRepoDao( String repositorio ) {
		return (Class<DAOE>) repos.get( repositorio );
	}

	public static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> DAOE forEntity( Class<E> tipoEntidad ) {
		return getInstance( getDefaultDao(), tipoEntidad );
	}

	public static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> DAOE getInstance( String repositorio, Class<E> tipoEntidad ) {
		return getInstance( getRepoDao(repositorio), tipoEntidad );
	}

	public static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> DAOE getInstance( Class<DAOE> tipoRepositorio, Class<E> tipoEntidad )
	{
		RepoEntidad re = new RepoEntidad( tipoRepositorio, tipoEntidad );
		if ( repositorios.containsKey( re ))
			return getRepositorio( re );
		else {
			DAOE tmpRepositorio;
			try {
				tmpRepositorio = tipoRepositorio.newInstance();
			} catch (Exception e) {
				try {
					tmpRepositorio = (DAOE) tipoRepositorio.getConstructors()[0].newInstance(tipoEntidad);
				} catch ( Exception e2 ) {
					e2.printStackTrace();
					throw new RuntimeException();
				}
			}

			repositorios.put( re, tmpRepositorio );
			return tmpRepositorio;
		}
	}

	private static class RepoEntidad {
		Class<? extends Dao> tipoRepositorio;
		Class<? extends EntidadIndexada> tipoEntidad;

		public RepoEntidad( Class<? extends DaoIndexado> tipoRepositorio, Class<? extends EntidadIndexada> tipoEntidad ) {
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

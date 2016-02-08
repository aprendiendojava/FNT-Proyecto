package com.wpsnetwork.dto.factorias;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.factorias.FactoriaDao;
import com.wpsnetwork.dao.fichero.RepositorioFicheroDao;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.memoria.RepositorioMemoriaDao;
import com.wpsnetwork.dto.Dto;

public final class FactoriaDto {
	private static Class<? extends Dao> defaultDao;
	private static Map<String,Class<? extends Dao>> repositorios = new HashMap<>();
	private static Map<String,Class<? extends EntidadIndexada>> entidades = new HashMap<>();
	static {
		repositorios.put( "MEMORIA", RepositorioMemoriaDao.class );
		repositorios.put( "FICHERO", RepositorioFicheroDao.class );
		entidades.put( "AUTOR", Autor.class );
		entidades.put( "CATEGORIA", CategoriaLibro.class );
		entidades.put( "LIBRO", Libro.class );
		entidades.put( "PERSONA", Persona.class );
		entidades.put( "PRESTAMO", Prestamo.class );
		defaultDao = getDefaultDao();
	}

	private FactoriaDto() {}

	public static <E extends EntidadIndexada> Dto<E> forEntity( String entidad ) {
		return getInstance( defaultDao, entidades.get(entidad ));
	}

	public static <E extends EntidadIndexada> Dto<E> forEntity( Class<? extends E> tipoEntidad ) {
		return getInstance( defaultDao, tipoEntidad );
	}

	public static <E extends EntidadIndexada> Dto<E> getInstance( String repositorio, String entidad ) {
		return getInstance(repositorios.get(repositorio), entidades.get(entidad));
	}

	public static <E extends EntidadIndexada> Dto<E> forRepo( Class<? extends Dao<E>> tipoRepositorio )
	{
		return getInstance( tipoRepositorio, (Class<E>)((ParameterizedType) tipoRepositorio.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public static <E extends EntidadIndexada> Dto<E> getInstance( Class<? extends Dao> tipoRepositorio, String entidad ) {
		return getInstance(tipoRepositorio, entidades.get(entidad));
	}

	public static <E extends EntidadIndexada> Dto<E> getInstance( Class<? extends Dao> tipoRepositorio, Class<? extends EntidadIndexada> tipoEntidad ) {
		return new Dto<E>( FactoriaDao.getInstance( tipoRepositorio, tipoEntidad ));
	}

	private static Class<? extends Dao> getDefaultDao() {
		Properties configuracion = new Properties();
		try {
			configuracion.load(new FileReader( "src/com/wpsnetwork/aplicacion.properties"));
			return repositorios.get( configuracion.getProperty("dao.acceso"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

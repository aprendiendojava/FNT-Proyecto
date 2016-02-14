package com.wpsnetwork.dto.factorias;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.factorias.FactoriaDao;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dto.Dto;

public final class FactoriaDto {
	private static Map<String,Class<? extends EntidadIndexada>> entidades = new HashMap<>();
	static {
		entidades.put( "AUTOR", Autor.class );
		entidades.put( "CATEGORIA", CategoriaLibro.class );
		entidades.put( "LIBRO", Libro.class );
		entidades.put( "PERSONA", Persona.class );
		entidades.put( "PRESTAMO", Prestamo.class );
	}

	private static <E extends EntidadIndexada> Class<E> getEntidad( String entidad ) {
		return (Class<E>) entidades.get(entidad);
	}
	private FactoriaDto() {}

	public static <E extends EntidadIndexada> Dto<E> forEntity( String entidad ) {
		return new Dto<E>( FactoriaDao.forEntity( getEntidad( entidad )));
	}

	public static <E extends EntidadIndexada> Dto<E> forEntity( Class<E> tipoEntidad ) {
		return new Dto<E>( FactoriaDao.forEntity( tipoEntidad ));
	}

	public static <E extends EntidadIndexada> Dto<E> getInstance( String repositorio, String entidad ) {
		return new Dto<E>( FactoriaDao.getInstance( repositorio, getEntidad(entidad)));
	}

	public static <E extends EntidadIndexada, DAOE extends Dao<E>> Dto<E> forRepo( Class<DAOE> tipoRepositorio )
	{
		return getInstance( tipoRepositorio, (Class<E>)((ParameterizedType) tipoRepositorio.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public static <E extends EntidadIndexada, DAOE extends Dao<E>> Dto<E> getInstance( Class<DAOE> tipoRepositorio, String entidad ) {
		return getInstance(tipoRepositorio, getEntidad(entidad));
	}

	public static <E extends EntidadIndexada, DAOE extends Dao<E>> Dto<E> getInstance( Class<DAOE> tipoRepositorio, Class<E> tipoEntidad ) {
		return new Dto<E>( FactoriaDao.getInstance( tipoRepositorio, tipoEntidad ));
	}
}

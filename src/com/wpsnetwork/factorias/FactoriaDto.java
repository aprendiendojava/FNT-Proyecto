package com.wpsnetwork.factorias;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import com.wpsnetwork.dao.interfaces.DaoIndexado;
import com.wpsnetwork.datos.entidades.Autor;
import com.wpsnetwork.datos.entidades.EntidadIndexada;
import com.wpsnetwork.datos.entidades.Libro;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.datos.entidades.CategoriaLibro;
import com.wpsnetwork.datos.entidades.Persona;
import com.wpsnetwork.datos.entidades.Prestamo;

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

	public static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> Dto<E> forRepo( Class<DAOE> tipoRepositorio )
	{
		return getInstance( tipoRepositorio, (Class<E>)((ParameterizedType) tipoRepositorio.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> Dto<E> getInstance( Class<DAOE> tipoRepositorio, String entidad ) {
		return getInstance(tipoRepositorio, getEntidad(entidad));
	}

	public static <E extends EntidadIndexada, DAOE extends DaoIndexado<E>> Dto<E> getInstance( Class<DAOE> tipoRepositorio, Class<E> tipoEntidad ) {
		return new Dto<E>( FactoriaDao.getInstance( tipoRepositorio, tipoEntidad ));
	}
}

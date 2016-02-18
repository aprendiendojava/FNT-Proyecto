package com.wpsnetwork.model.factoria;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import com.wpsnetwork.dao.interfaces.DaoIndexado;
import com.wpsnetwork.datos.entidades.AutorDto;
import com.wpsnetwork.datos.entidades.CategoriaLibroDto;
import com.wpsnetwork.datos.entidades.LibroDto;
import com.wpsnetwork.datos.entidades.PersonaDto;
import com.wpsnetwork.datos.entidades.PrestamoDto;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.model.entidad.EntidadIndexada;

public final class FactoriaDto {
	private static Map<String,Class<? extends EntidadIndexada>> entidades = new HashMap<>();
	static {
		entidades.put( "AUTOR", AutorDto.class );
		entidades.put( "CATEGORIA", CategoriaLibroDto.class );
		entidades.put( "LIBRO", LibroDto.class );
		entidades.put( "PERSONA", PersonaDto.class );
		entidades.put( "PRESTAMO", PrestamoDto.class );
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

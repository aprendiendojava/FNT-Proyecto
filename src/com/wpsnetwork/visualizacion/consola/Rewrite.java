package com.wpsnetwork.visualizacion.consola;

import java.util.Arrays;

import com.wpsnetwork.dao.repositorios.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.datos.entidades.AutorDto;
import com.wpsnetwork.datos.entidades.LibroDto;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.model.factoria.FactoriaDto;

public class Rewrite {
	public static void main( String...strings ) {
		Dto<AutorDto> autores = FactoriaDto.forRepo( RepositorioAutoresMemoriaDao.class );
		Dto<LibroDto> libros = FactoriaDto.forEntity( LibroDto.class );
		Arrays.asList(
			new LibroDto( "Moby Dick", 300, "Astral", 34 ),
			new LibroDto( "Las flores del mal", 140, "Editorial3", 11 ),
			new LibroDto( "Rayuela", 400, "Editorial1", 14 ),
			new LibroDto( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( l ));

		autores.getAll().get(0).getLibros().getAll().forEach(l-> System.out.println(l));

	}
}

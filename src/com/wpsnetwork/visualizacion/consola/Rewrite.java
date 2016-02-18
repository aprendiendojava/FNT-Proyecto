package com.wpsnetwork.visualizacion.consola;

import java.util.Arrays;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.interfaz.Dao;
import com.wpsnetwork.custom.dto.AutorDto;
import com.wpsnetwork.custom.dto.LibroDto;
import com.wpsnetwork.custom.repositorio.RepositorioAutoresMemoriaDao;

public class Rewrite {
	public static void main( String...strings ) {
		Dao<AutorDto> autores = FactoriaDao.getInstance( RepositorioAutoresMemoriaDao.class, AutorDto.class );
		Dao<LibroDto> libros = FactoriaDao.forEntity( LibroDto.class );
		Arrays.asList(
			new LibroDto( "Moby Dick", 300, "Astral", 34 ),
			new LibroDto( "Las flores del mal", 140, "Editorial3", 11 ),
			new LibroDto( "Rayuela", 400, "Editorial1", 14 ),
			new LibroDto( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( l ));

		autores.getAll().get(0).getLibros().getAll().forEach(l-> System.out.println(l));

	}
}

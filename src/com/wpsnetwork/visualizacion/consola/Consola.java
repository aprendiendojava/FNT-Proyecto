package com.wpsnetwork.visualizacion.consola;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.repositorios.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.dao.repositorios.RepositorioHibernateDao;
import com.wpsnetwork.datos.entidades.AutorDto;
import com.wpsnetwork.datos.entidades.CategoriaLibroDto;
import com.wpsnetwork.datos.entidades.LibroDto;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.model.factoria.FactoriaDto;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		Dto<AutorDto> autores = FactoriaDto.forRepo( RepositorioAutoresMemoriaDao.class );
		logConsola.trace( imprimir( autores ));




		Dto<AutorDto> autores2 = FactoriaDto.forEntity( "AUTOR" );
		autores.getAll().forEach( a -> autores2.insert( a ));
		logConsola.trace( imprimir( autores2 ));
		logConsola.trace( imprimir( autores ));

		AutorDto cortazar = new AutorDto( "Julio Cortazar" );
		autores2.insert( cortazar );
		logConsola.trace( imprimir( autores2 ));

		autores2.update( cortazar, new AutorDto( "Julio Cortázar" ));
		logConsola.trace( imprimir( autores2 ));




		Dto<CategoriaLibroDto> categorias = FactoriaDto.getInstance( RepositorioHibernateDao.class, CategoriaLibroDto.class );
		Arrays.asList(
			new CategoriaLibroDto( "Novela" ),
			new CategoriaLibroDto( "Poesía" ),
			new CategoriaLibroDto( "Drama" ),
			new CategoriaLibroDto( "Ensayo" )
		).forEach( cl -> categorias.insert( cl ));
		logConsola.trace( imprimir( categorias ));




		Dto<LibroDto> libros = FactoriaDto.forEntity( LibroDto.class );
		Arrays.asList(
			new LibroDto( "Moby Dick", 300, "Astral", 34 ),
			new LibroDto( "Las flores del mal", 140, "Editorial3", 11 ),
			new LibroDto( "Rayuela", 400, "Editorial1", 14 ),
			new LibroDto( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( l ));
		logConsola.trace( imprimir( libros ));

		libros.delete( libros.get(1));
		logConsola.trace( imprimir( libros ));
	}

	private static String imprimir( Dto<?> objetos ) {
		return objetos.getAll().stream()
				.map(l->l.toString())
				.reduce((texto,l) -> texto + l.toString()).orElse("Lista vacía");
	}
}

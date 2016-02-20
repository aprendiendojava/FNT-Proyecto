package com.wpsnetwork.visualizacion.consola;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.interfaz.DaoIndexado;
import com.wpsnetwork.custom.dto.AutorDto;
import com.wpsnetwork.custom.dto.CategoriaLibroDto;
import com.wpsnetwork.custom.dto.LibroDto;
import com.wpsnetwork.custom.repositorio.RepositorioAutoresMemoriaDao;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		DaoIndexado<AutorDto> autores = FactoriaDao.getInstance( RepositorioAutoresMemoriaDao.class, AutorDto.class );
		logConsola.trace( imprimir( autores ));




		DaoIndexado<AutorDto> autores2 = FactoriaDao.forEntity( AutorDto.class );
		autores.getAll().forEach( a -> autores2.insert( a ));
		logConsola.trace( imprimir( autores2 ));
		logConsola.trace( imprimir( autores ));

		AutorDto cortazar = new AutorDto( "Julio Cortazar" );
		autores2.insert( cortazar );
		logConsola.trace( imprimir( autores2 ));

		autores2.update( cortazar, new AutorDto( "Julio Cortázar" ));
		logConsola.trace( imprimir( autores2 ));




		DaoIndexado<CategoriaLibroDto> categorias = FactoriaDao.forEntity( CategoriaLibroDto.class );
		Arrays.asList(
			new CategoriaLibroDto( "Novela" ),
			new CategoriaLibroDto( "Poesía" ),
			new CategoriaLibroDto( "Drama" ),
			new CategoriaLibroDto( "Ensayo" )
		).forEach( cl -> categorias.insert( cl ));
		logConsola.trace( imprimir( categorias ));




		DaoIndexado<LibroDto> libros = FactoriaDao.forEntity( LibroDto.class );
		Arrays.asList(
			new LibroDto( "Moby Dick", 300, "Astral", 34 ),
			new LibroDto( "Las flores del mal", 140, "Editorial3", 11 ),
			new LibroDto( "Rayuela", 400, "Editorial1", 14 ),
			new LibroDto( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( l ));
		logConsola.trace( imprimir( libros ));
//		cortazar.addLibro(libros.get(3));


		libros.delete( libros.getAll().get(1));
		logConsola.trace( imprimir( libros ));
	}

	private static String imprimir( DaoIndexado<?> objetos ) {
		return objetos.getAll().stream()
				.map(l->l.toString())
				.reduce((texto,l) -> texto + l.toString()).orElse("Lista vacía");
	}
}

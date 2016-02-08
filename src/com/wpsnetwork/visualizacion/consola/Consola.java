package com.wpsnetwork.visualizacion.consola;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.factorias.FactoriaDao;
import com.wpsnetwork.dao.memoria.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.dao.memoria.RepositorioMemoriaDao;
import com.wpsnetwork.dto.AutoresDto;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.dto.entidades.Autor;
import com.wpsnetwork.dto.entidades.Libro;
import com.wpsnetwork.dto.factorias.FactoriaDto;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		Dto<com.wpsnetwork.dao.entidades.Autor> autores =
				FactoriaDto.getInstance( RepositorioAutoresMemoriaDao.class );
		logConsola.trace( imprimir( autores ));

		Autor autor = new Autor( new com.wpsnetwork.dao.entidades.Autor( "Julio Cortazar" ));
		autores.insert( autor );
		logConsola.trace( imprimir( autores ));

		Dto<com.wpsnetwork.dao.entidades.Autor> autores2 =
				FactoriaDto.getInstance( "MEMORIA", "AUTOR" );
		AutoresDto autores3 = new AutoresDto( FactoriaDao.getInstance( RepositorioMemoriaDao.class, com.wpsnetwork.dao.entidades.Autor.class ));
		logConsola.trace( imprimir( autores ));
		logConsola.trace( "AUTORES 2" + imprimir( autores2 ));
		logConsola.trace( "AUTORES 3" + imprimir( autores3 ));

		autor.updateEntidad( new com.wpsnetwork.dao.entidades.Autor( "Julio Cortázar" ));
		autores.update( autor );
		logConsola.trace( imprimir( autores ));
		logConsola.trace( "AUTORES 2" + imprimir( autores2 ));

		autores.delete( autor );
		logConsola.trace( imprimir( autores ));

		Dto<com.wpsnetwork.dao.entidades.Libro> libros =
				FactoriaDto.getInstance( "MEMORIA", "LIBRO" );
		Libro libro = new Libro( new com.wpsnetwork.dao.entidades.Libro( "Rayuela", 400, "Editorial1", 14 ));
		libros.insert( libro );
		logConsola.trace( imprimir( libros ));

		libro = new Libro( new com.wpsnetwork.dao.entidades.Libro( "La amabilidad de los extraños", 90, "Editorial2", 1 ));
		libros.insert( libro );
		logConsola.trace( imprimir( libros ));

		Dto<com.wpsnetwork.dao.entidades.CategoriaLibro> categorias =
				FactoriaDto.getInstance( "MEMORIA", "CATEGORIA" );
		logConsola.trace( imprimir( categorias ));

//		Dto.connect( autores, )
		//Dto<LibroNNAutor> librosNNautores = FactoriaDto.getInstance( RepositorioLibrosNNAutores.class, LibroNNAutor.class );
	}

	private static String imprimir( Dto<?> objetos ) {
		return objetos.getAll().stream()
				.map(l->l.toString())
				.reduce((texto,l) -> texto + l.toString()).orElse("Lista vacía");
	}
}

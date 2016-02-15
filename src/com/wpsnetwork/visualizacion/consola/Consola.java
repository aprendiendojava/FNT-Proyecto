package com.wpsnetwork.visualizacion.consola;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.impl.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.dao.impl.RepositorioHibernateDao;
import com.wpsnetwork.dto.impl.Dto;
import com.wpsnetwork.factorias.FactoriaDto;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		Dto<com.wpsnetwork.dao.entidades.Autor> autores = FactoriaDto.forRepo( RepositorioAutoresMemoriaDao.class );
		logConsola.trace( imprimir( autores ));




		Dto<com.wpsnetwork.dao.entidades.Autor> autores2 = FactoriaDto.forEntity( "AUTOR" );
		autores.getAll().forEach( a -> autores2.insert( a ));
		logConsola.trace( imprimir( autores2 ));
		logConsola.trace( imprimir( autores ));

		com.wpsnetwork.dto.entidades.Autor cortazar = new com.wpsnetwork.dto.entidades.Autor( new Autor( "Julio Cortazar" ));
		autores2.insert( cortazar );
		logConsola.trace( imprimir( autores2 ));

		cortazar.updateEntidad( new Autor( "Julio Cortázar"));
		autores2.update( cortazar );
		logConsola.trace( imprimir( autores2 ));




		Dto<CategoriaLibro> categorias = FactoriaDto.getInstance( RepositorioHibernateDao.class, CategoriaLibro.class );
		Arrays.asList(
			new CategoriaLibro( "Novela" ),
			new CategoriaLibro( "Poesía" ),
			new CategoriaLibro( "Drama" ),
			new CategoriaLibro( "Ensayo" )
		).forEach( cl -> categorias.insert( new com.wpsnetwork.dto.entidades.CategoriaLibro( cl )));
		logConsola.trace( imprimir( categorias ));




		Dto<Libro> libros = FactoriaDto.forEntity( Libro.class );
		Arrays.asList(
			new Libro( "Moby Dick", 300, "Astral", 34 ),
			new Libro( "Las flores del mal", 140, "Editorial3", 11 ),
			new Libro( "Rayuela", 400, "Editorial1", 14 ),
			new Libro( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( new com.wpsnetwork.dto.entidades.Libro( l )));
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

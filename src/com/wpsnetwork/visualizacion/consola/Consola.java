package com.wpsnetwork.visualizacion.consola;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.repository.Dao;
import com.wpsnetwork.custom.dto.Autor;
import com.wpsnetwork.custom.dto.CategoriaLibro;
import com.wpsnetwork.custom.dto.Libro;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		Dao<Autor> autores2 = FactoriaDao.forEntity( Autor.class );
		Autor cortazar = new Autor( "Julio Cortazar" );
		cortazar.getLibros().add(new Libro( "Rayuela", 400, "Editorial1", 14 ));
		autores2.insert( cortazar );
		cortazar.getLibros().add(new Libro( "El perseguidor", 100, "Editorial1", 8 ));
		logConsola.trace( imprimir( autores2 ));

		autores2.update( cortazar, new Autor( "Julio Cortázar" ));
		logConsola.trace( imprimir( autores2 ));




		Dao<CategoriaLibro> categorias = FactoriaDao.forEntity( CategoriaLibro.class );
		Arrays.asList(
			new CategoriaLibro( "Novela" ),
			new CategoriaLibro( "Poesía" ),
			new CategoriaLibro( "Drama" ),
			new CategoriaLibro( "Ensayo" )
		).forEach( cl -> categorias.insert( cl ));
		logConsola.trace( imprimir( categorias ));




		Dao<Libro> libros = FactoriaDao.forEntity( Libro.class );
		Arrays.asList(
			new Libro( "Moby Dick", 300, "Astral", 34 ),
			new Libro( "Las flores del mal", 140, "Editorial3", 11 ),
			new Libro( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> {
			libros.insert( l );
			l.getAutores().add(autores2.get(1));
			l.getAutores().add(new Autor("Kurt Vonnegut"));
		});
		logConsola.trace( imprimir( libros ));




		libros.delete( libros.getAll().get(1));
		logConsola.trace( imprimir( libros ));
	}

	private static String imprimir( Dao<?> objetos ) {
		return objetos.getAll().stream()
				.map(l->l.toString())
				.reduce((texto,l) -> texto + l.toString()).orElse("Lista vacía");
	}
}

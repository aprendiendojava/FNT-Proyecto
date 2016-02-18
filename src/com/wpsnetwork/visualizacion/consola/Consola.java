package com.wpsnetwork.visualizacion.consola;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.dao.repositorios.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.dao.repositorios.RepositorioHibernateDao;
import com.wpsnetwork.datos.entidades.Autor;
import com.wpsnetwork.datos.entidades.CategoriaLibro;
import com.wpsnetwork.datos.entidades.Libro;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.dto.EntidadDto;
import com.wpsnetwork.factorias.FactoriaDto;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		Dto<Autor> autores = FactoriaDto.forRepo( RepositorioAutoresMemoriaDao.class );
		logConsola.trace( imprimir( autores ));




		Dto<Autor> autores2 = FactoriaDto.forEntity( "AUTOR" );
		autores.getAll().forEach( a -> autores2.insert( a ));
		logConsola.trace( imprimir( autores2 ));
		logConsola.trace( imprimir( autores ));

		EntidadDto<Autor> cortazar = new EntidadDto<>( new Autor( "Julio Cortazar" ));
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
		).forEach( cl -> categorias.insert( new EntidadDto<CategoriaLibro>( cl )));
		logConsola.trace( imprimir( categorias ));




		Dto<Libro> libros = FactoriaDto.forEntity( Libro.class );
		Arrays.asList(
			new Libro( "Moby Dick", 300, "Astral", 34 ),
			new Libro( "Las flores del mal", 140, "Editorial3", 11 ),
			new Libro( "Rayuela", 400, "Editorial1", 14 ),
			new Libro( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( new EntidadDto<Libro>( l )));
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

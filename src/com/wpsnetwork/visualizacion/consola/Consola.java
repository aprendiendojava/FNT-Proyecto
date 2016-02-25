package com.wpsnetwork.visualizacion.consola;
import java.time.LocalDate;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.repository.Dao;
import com.wpsnetwork.custom.dto.Autor;
import com.wpsnetwork.custom.dto.Categoria;
import com.wpsnetwork.custom.dto.Libro;
import com.wpsnetwork.custom.dto.Persona;
import com.wpsnetwork.custom.dto.Prestamo;

public final class Consola {
	private static final Logger logConsola = LogManager.getLogger( Consola.class );

	public static void main( String...strings ) {
		Dao<Autor> autores2 = FactoriaDao.forEntity( Autor.class );
		Autor cortazar = new Autor( "Julio Cortazar" );
		cortazar.getLibros().add(new Libro( "Rayuela", 400, "Editorial1", 14 ));

		autores2.insert( cortazar );
		cortazar.getLibros().add(new Libro( "El perseguidor", 100, "Editorial1", 8 ));
//		logConsola.trace( imprimir( autores2 ));

		autores2.update( cortazar, new Autor( "Julio Cortázar" ));
//		logConsola.trace( imprimir( autores2 ));




		Dao<Categoria> categorias = FactoriaDao.forEntity( Categoria.class );
		Arrays.asList(
			new Categoria( "Novela" ),
			new Categoria( "Poesía" ),
			new Categoria( "Drama" ),
			new Categoria( "Ensayo" )
		).forEach( cl -> categorias.insert( cl ));
//		logConsola.trace( imprimir( categorias ));




		Dao<Libro> libros = FactoriaDao.forEntity( Libro.class );
		Autor vonnegut = new Autor("Kurt Vonnegut");
		Arrays.asList(
			new Libro( "Moby Dick", 300, "Astral", 34 ),
			new Libro( "Las flores del mal", 140, "Editorial3", 11 ),
			new Libro( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> {
			libros.insert( l );
			l.getAutores().add(autores2.get(1));
			l.getAutores().add(vonnegut);
		});
//		logConsola.trace( imprimir( libros ));




		try {
			//libros.delete( libros.getAll().get(1));
			libros.update(libros.getAll().get(1), new Libro("CAMBIADO", 3, "EDITORIAL", 2));
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
//		logConsola.trace( imprimir( libros ));



//		try {
//			autores2.delete(cortazar);
//		} catch( Exception e ) {
//			e.printStackTrace();
//			System.out.println("Falla porque el autor cortazar fue actualizado.");
//		}

		Dao<Prestamo> prestamos = FactoriaDao.forEntity(Prestamo.class);
		prestamos.insert(new Prestamo(libros.getAll().get(1),new Persona("Persona1", "DNI1", LocalDate.now(), "Direccion1", "0000000", "Provincia1", "Pasi2", 0)));
//		logConsola.trace(prestamos);
		
	}

	private static String imprimir( Dao<?> objetos ) {
		return objetos.getAll().stream()
				.map(l->l.toString())
				.reduce((texto,l) -> texto + l.toString()).orElse("Lista vacía");
	}
}

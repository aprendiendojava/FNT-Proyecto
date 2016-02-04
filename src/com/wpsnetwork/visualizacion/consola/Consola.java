package com.wpsnetwork.visualizacion.consola;
import java.util.Arrays;

import com.wpsnetwork.dao.memoria.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.dao.memoria.RepositorioLibrosMemoriaDao;
import com.wpsnetwork.dto.AutoresDto;
import com.wpsnetwork.dto.LibrosDto;
import com.wpsnetwork.dto.entidades.Autor;
import com.wpsnetwork.dto.entidades.Libro;

public class Consola {

	public static void main( String...strings ) {
		AutoresDto autores = new AutoresDto();
		System.out.println(Arrays.toString( autores.imprimir().toArray()));
		Autor autor = new Autor( "Julio Cortazar" );
		autores.insert( autor );
		System.out.println(Arrays.toString( autores.imprimir().toArray()));
		autores.delete( autor );
		System.out.println(Arrays.toString( autores.imprimir().toArray()));

		LibrosDto libros = new LibrosDto();
		Libro libro = new Libro( "Rayuela" );
		libros.insert(libro);
		System.out.println(Arrays.toString( libros.imprimir().toArray()));
		libro = new Libro( "La amabilidad de los extraños" );
		libros.insert(libro);
		System.out.println(Arrays.toString( libros.imprimir().toArray()));

		System.out.println( libros.get(1).getEntidad().toString());
	}
}

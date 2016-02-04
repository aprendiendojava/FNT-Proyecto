package com.wpsnetwork.visualizacion.consola;
import com.wpsnetwork.dto.AutoresDto;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.dto.LibrosDto;
import com.wpsnetwork.dto.entidades.Autor;
import com.wpsnetwork.dto.entidades.Libro;

public class Consola {

	public static void main( String...strings ) {
		AutoresDto autores = new AutoresDto();
		imprimir( autores );

		Autor autor = new Autor( "Julio Cortazar" );
		autores.insert( autor );
		imprimir( autores );

		autores.delete( autor );
		imprimir( autores );

		LibrosDto libros = new LibrosDto();
		Libro libro = new Libro( "Rayuela" );
		libros.insert(libro);
		imprimir( libros );

		libro = new Libro( "La amabilidad de los extraños" );
		libros.insert(libro);
		imprimir( libros );		
	}

	private static void imprimir( Dto objetos ) {
		System.out.println( "\n"+
				objetos.getAll().stream()
						.map(l->l.toString())
						.reduce((texto,l) -> texto + ", " + l.toString()).get()
		);
	}
}

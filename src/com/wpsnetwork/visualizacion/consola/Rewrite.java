package com.wpsnetwork.visualizacion.consola;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.interfaz.Dao;
import com.wpsnetwork.custom.dto.AutorDto;

public class Rewrite {
	public static void main( String...strings ) {
		Dao<AutorDto> autores = FactoriaDao.forEntity( AutorDto.class );
//		Arrays.asList(
//			new LibroDto( "Moby Dick", 300, "Astral", 34 ),
//			new LibroDto( "Las flores del mal", 140, "Editorial3", 11 ),
//			new LibroDto( "Rayuela", 400, "Editorial1", 14 ),
//			new LibroDto( "La amabilidad de los extraños", 90, "Editorial2", 1 )
//		).forEach( l -> libros.insert( l ));

		autores.getAll().forEach( a-> {
			System.out.println(a);
			a.getLibros().forEach(l-> {
				System.out.println("\t"+l);
				l.getAutores().stream().filter(x->!a.equals(x)).forEach(a2-> System.out.println("\t\t"+a2));
			});
			System.out.println("--------------------------------------------------------");
		});

	}
}

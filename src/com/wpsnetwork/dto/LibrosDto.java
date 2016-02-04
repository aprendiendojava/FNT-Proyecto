package com.wpsnetwork.dto;

import com.wpsnetwork.dao.memoria.RepositorioLibrosMemoriaDao;
import com.wpsnetwork.dto.entidades.Libro;

public class LibrosDto extends Dto<RepositorioLibrosMemoriaDao,Libro,com.wpsnetwork.dao.entidades.Libro> {
	public LibrosDto() { super( new RepositorioLibrosMemoriaDao(),new Libro()); }
}

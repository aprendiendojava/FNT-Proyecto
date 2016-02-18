package com.wpsnetwork.base.repositorio;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.wpsnetwork.base.entidad.EntidadIndexada;

public class RepositorioFicheroDao<ENTIDAD extends EntidadIndexada> extends RepositorioIndexado<ENTIDAD> {
	private final Path almacen;
	private final Properties db = new Properties();

	public RepositorioFicheroDao(Class<ENTIDAD> claseEntidad) {
		super(claseEntidad);
		this.almacen = Paths.get("dao", "fichero", claseEntidad.getCanonicalName());
		try {
			Files.createDirectories(almacen.getParent());
			try {
				Files.createFile(almacen);
			} catch (Exception e) {
				;
			}
			db.load( Files.newInputStream(almacen));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ENTIDAD get( Serializable id) {
		try {
			return new Gson().fromJson((String) db.get(""+id), getClaseRepositorio());
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insert( ENTIDAD object ) {
		if ( object.getIndex() == null )
			assignId( object );

		insertOrUpdate( object, object );		
	}

	@Override
	public void update(ENTIDAD original, ENTIDAD updated) {
		ENTIDAD saved = get(original.getIndex());
		if( saved == null )
			throw new RuntimeException();
		else {
			insertOrUpdate(original, updated);
		}
	}

	private void insertOrUpdate( ENTIDAD original, ENTIDAD updated ) {
		try {
			db.setProperty( original.getIndex().toString(), new Gson().toJson( updated ));
			db.store( Files.newBufferedWriter( almacen ), "" );
			repositoryChanged( updated );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ENTIDAD object) {
		db.remove(object.getIndex());
		try {
			db.store(Files.newBufferedWriter(almacen),"");
			repositoryChanged(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ENTIDAD> getAll() {
		return db.values()
				.stream()
				.map(o-> {
			try {
				return (ENTIDAD) new Gson()
						.fromJson((String) o, getClaseRepositorio());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}).collect(Collectors.toList());
	}
}

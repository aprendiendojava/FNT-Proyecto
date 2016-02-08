package com.wpsnetwork.dao.fichero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Observable;
import java.util.Properties;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Dao;

public class RepositorioFicheroDao<ENTIDAD extends EntidadIndexada> extends Observable implements Dao<ENTIDAD> {
	private Path almacen;
	private Properties db = new Properties();

	private void crear(Class<?> c) {
		try {
			almacen = Paths.get("dao", "fichero",c.getCanonicalName());
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
	public ENTIDAD get(int id) {
		try {
			return new Gson().fromJson((String) db.get(""+id), Class.forName( almacen.getFileName().toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insert(ENTIDAD object) {
		crear( object.getClass());
		try {
			db.setProperty(""+object.getId(), new Gson().toJson(object));
			db.store( Files.newBufferedWriter(almacen ), "" );

			setChanged();
			notifyObservers(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ENTIDAD object) {
		insert(object);
	}

	@Override
	public void delete(ENTIDAD object) {
		db.remove(object.getId());
		try {
			db.store(Files.newBufferedWriter(almacen),"");

			setChanged();
			notifyObservers(object);
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
						.fromJson((String) o, Class.forName( almacen.getFileName().toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}).collect(Collectors.toList());
	}
}

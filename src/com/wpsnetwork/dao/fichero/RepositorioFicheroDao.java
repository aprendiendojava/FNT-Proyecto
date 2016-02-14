package com.wpsnetwork.dao.fichero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.wpsnetwork.dao.RepositorioGenerico;
import com.wpsnetwork.dao.entidades.EntidadIndexada;

public class RepositorioFicheroDao<ENTIDAD extends EntidadIndexada> extends RepositorioGenerico<ENTIDAD> {
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
	public ENTIDAD get(int id) {
		try {
			return new Gson().fromJson((String) db.get(""+id), getClaseRepositorio());
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insert(ENTIDAD object) {
		try {
			db.setProperty(""+object.getId(), new Gson().toJson(object));
			db.store( Files.newBufferedWriter(almacen ), "" );
			repositoryChanged(object);
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

package com.wpsnetwork.dto;

import java.util.List;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.interfaces.Indexado;
import com.wpsnetwork.dto.entidades.EntidadDto;

public abstract class Dto<REPO extends Dao<ENTIDAD>, ENT_DTO extends EntidadDto<ENTIDAD>, ENTIDAD extends Indexado> implements Dao<ENT_DTO> {
	private REPO repositorio;
	private ENT_DTO ent_dto;

	public Dto( REPO repositorio, ENT_DTO ent_dto ) {
		this.repositorio = repositorio;
		this.ent_dto = ent_dto;
	}

	protected REPO getRepositorio() { return repositorio; }

	@Override
	public ENT_DTO get(int id) {
		ent_dto.setEntidad( repositorio.get(id));
		return ent_dto;
	}

	@Override
	public void insert(ENT_DTO element) {
		repositorio.insert( element.getEntidad());
	}

	@Override
	public void update(ENT_DTO element) {
		repositorio.update( element.getEntidad());
	}

	@Override
	public void delete(ENT_DTO element) {
		repositorio.delete( element.getEntidad());
	}

	@Override
	public List<ENT_DTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ENTIDAD> imprimir() { return repositorio.getAll(); }
}

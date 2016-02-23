package com.wpsnetwork.custom.entity;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entity.Table;

@MappedSuperclass
public abstract class Autor extends Table{
	protected String nombre;
}

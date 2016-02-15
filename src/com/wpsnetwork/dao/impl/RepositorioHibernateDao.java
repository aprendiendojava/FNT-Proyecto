package com.wpsnetwork.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wpsnetwork.dao.entidades.EntidadIndexada;

public class RepositorioHibernateDao<ENTIDAD extends EntidadIndexada> extends RepositorioIndexado<ENTIDAD> {
	public RepositorioHibernateDao(Class<ENTIDAD> claseEntidad) {
		super(claseEntidad);
	}

	private static SessionFactory sf;
	private static Session s;
	static {
		try {
			sf = new Configuration().setInterceptor(new ReflectiveInstantiator()).configure().buildSessionFactory();
			s = sf.openSession();
		} catch( Exception e ) {
			System.out.println("NO SE HA PODIDO CONECTAR CON LA BASE DE DATOS");
		}
	}

	@Override
	public ENTIDAD get( Serializable id ) {
		s.beginTransaction();
		return (ENTIDAD) s.get(getClaseRepositorio(), id);
	}

	@Override
	public void insert(ENTIDAD object) {
		try {
		s.beginTransaction();
		s.save(object);
		s.getTransaction().commit();
		repositoryChanged(object);
		} catch ( Exception e ) {
			System.out.println("NO SE HA PODIDO CONECTAR CON LA BASE DE DATOS");
		}
	}

	@Override
	public void update(ENTIDAD object) {
		try {
		s.beginTransaction();
		s.update(object);
		s.getTransaction().commit();
		repositoryChanged(object);
		} catch ( Exception e ) {
			System.out.println("NO SE HA PODIDO CONECTAR CON LA BASE DE DATOS");
		}
	}

	@Override
	public void delete(ENTIDAD object) {
		try {
		s.beginTransaction();
		s.delete(object);
		s.getTransaction().commit();
		repositoryChanged(object);
		} catch (Exception e) {
			System.out.println("NO SE HA PODIDO CONECTAR CON LA BASE DE DATOS");
		}
	}

	@Override
	public List<ENTIDAD> getAll() {
		try {
		s.beginTransaction();
		return s.createQuery("FROM " + getClaseRepositorio().getSimpleName()).list();
		} catch (Exception e){
			System.out.println("NO SE HA PODIDO CONECTAR CON LA BASE DE DATOS");
			return new ArrayList<>();
		}
	}

	private static class ReflectiveInstantiator extends EmptyInterceptor {
		@Override
		public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
			Object o;
			try {
				o = sun.reflect.ReflectionFactory.getReflectionFactory().newConstructorForSerialization(Class.forName(entityName), EntidadIndexada.class.getConstructor()).newInstance();
				Class c = o.getClass();
				Field[] fs;
				Field fi;
				do {
					fs = c.getDeclaredFields();
					fi = Arrays.asList(fs).stream().filter(f->f.getName().equals("id")).findAny().orElse(null);
					c = c.getSuperclass();
				} while ( c != null && fi == null);
				if ( fi != null ) {
					fi.setAccessible(true);
					fi.set(o, id);
				}
			} catch (Exception e) {
				e.printStackTrace();
				o = null;
			}
			return o;
		}
	}
}

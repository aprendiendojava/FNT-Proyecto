package com.wpsnetwork.base.repository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

import com.wpsnetwork.base.entity.Table;

public class Hibernate<ENTIDAD extends Table> implements Dao<ENTIDAD> {
	private final Class<ENTIDAD> claseRepositorio;

	public Hibernate(Class<ENTIDAD> claseEntidad) {
		this.claseRepositorio = claseEntidad;
	}

	private static SessionFactory sf;
	private static Session s;
	static {
		sf = new Configuration().setInterceptor(new ReflectiveInstantiator()).configure().buildSessionFactory();
		s = sf.openSession();
	}

	@Override
	public ENTIDAD get( Serializable id ) {
		s.beginTransaction();
		return (ENTIDAD) s.get(claseRepositorio, id);
	}

	@Override
	public void insert(ENTIDAD object) {
		s.beginTransaction();
		s.save(object);
		s.getTransaction().commit();
	}

	@Override
	public void update(ENTIDAD original, ENTIDAD updated) {
		s.beginTransaction();
		s.flush();
		s.evict(original);
		s.getTransaction().commit();

		StatelessSession ss = sf.openStatelessSession();
		ss.beginTransaction();
		updated.setIndex(original.getIndex());
		ss.update(updated);
		ss.getTransaction().commit();
		ss.close();
	}

	@Override
	public void delete(ENTIDAD object) {
		s.beginTransaction();
		s.delete(object);
		s.getTransaction().commit();
	}

	@Override
	public List<ENTIDAD> getAll() {
			s.beginTransaction();
			return s.createQuery( "FROM " + claseRepositorio.getSimpleName()).list();
	}

	private static class ReflectiveInstantiator extends EmptyInterceptor {
		@Override
		public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
			Object o;
			try {
				o = sun.reflect.ReflectionFactory.getReflectionFactory().newConstructorForSerialization( Class.forName(entityName), Table.class.getConstructor()).newInstance();
				Class c = o.getClass();
				Field[] fs;
				Field fi;
				do {
					fs = c.getDeclaredFields();
					fi = Arrays.asList(fs).stream().filter(f-> f.getName().equals("id")).findAny().orElse(null);
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

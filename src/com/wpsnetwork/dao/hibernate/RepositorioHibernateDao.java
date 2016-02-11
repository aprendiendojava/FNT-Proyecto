package com.wpsnetwork.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.entidades.EntidadIndexada;
import com.wpsnetwork.dao.interfaces.Dao;

public class RepositorioHibernateDao<ENTIDAD extends EntidadIndexada> implements Dao<ENTIDAD> {
	private static SessionFactory sf = new Configuration().setInterceptor(new ReflectiveInstantiator()).configure().buildSessionFactory();
	private static Session s = sf.openSession();

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

	@Override
	public ENTIDAD get(int id) {
		s.beginTransaction();
		return (ENTIDAD) s.get(Autor.class, id);
	}

	@Override
	public void insert(ENTIDAD object) {
		s.beginTransaction();
		s.save(object);
		s.getTransaction().commit();
	}

	@Override
	public void update(ENTIDAD object) {
		s.beginTransaction();
		s.update(object);
		s.getTransaction().commit();
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
		return s.createQuery("FROM Autor").list();
	}

}

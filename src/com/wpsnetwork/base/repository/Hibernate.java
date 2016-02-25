package com.wpsnetwork.base.repository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

import com.wpsnetwork.base.entity.Table;

public class Hibernate<ENTIDAD extends Table, DTO extends ENTIDAD> implements Dao<ENTIDAD> {
	private static final Logger logDao = LogManager.getLogger( Hibernate.class );
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
		logDao.trace("INSERTANDO:");
		logDao.trace(object);		
		try {
			s.beginTransaction();
			s.save(object);
			s.getTransaction().commit();
			logDao.trace("INSERTADO CORRECTAMENTE.");
		} catch ( Exception e ) {
			logDao.trace("ERROR AL INSERTAR: " + e );
			s.getTransaction().rollback();
		}
		
	}

	@Override
	public void update(ENTIDAD original, ENTIDAD updated) {
		logDao.trace("ACTUALIZANDO:");
		logDao.trace(original);
		try {
			s.beginTransaction();
			s.flush();
			s.evict(original);
			s.getTransaction().commit();

			StatelessSession ss = sf.openStatelessSession();
			try {
				ss.beginTransaction();
				updated.setIndex(original.getIndex());
				ss.update(updated);
				ss.getTransaction().commit();
				logDao.trace("ACTUALIZADO CORRECTAMENTE COMO:");
				logDao.trace(updated);
			} catch( Exception e ) {
				ss.getTransaction().rollback();
			} finally {
				ss.close();
			}
		} catch (Exception e ) {
			logDao.trace("ERROR AL ACTUALIZAR: " + e );
			s.getTransaction().rollback();
		}
	}

	@Override
	public void delete(ENTIDAD object) {
		logDao.trace("PREPARANDO EL BORRADO DE:");
		logDao.trace(object);

		logDao.trace("BORRANDO REFERENCIAS AL OBJETO.");
		List<Field> fs = Arrays.asList( object.getClass().getDeclaredFields());
		Stream<Field> fss = fs.stream().filter(f->{
			boolean b = f.isAnnotationPresent(ManyToMany.class)||f.isAnnotationPresent(OneToMany.class);
			return b;
		});
		fss.forEach(f->{
			f.setAccessible(true);
			try {
				Collection<ENTIDAD> c = (Collection<ENTIDAD>) f.get(object);
				c.stream().forEach( t->
				{
					ENTIDAD t2 = t;
					Arrays.asList( t.getClass().getDeclaredFields())
					.stream().filter(f2-> f2.isAnnotationPresent(ManyToMany.class)||f2.isAnnotationPresent(OneToMany.class))
					.forEach(f3->{
						f3.setAccessible(true);
						
						try {
							Collection<ENTIDAD> c2 = (Collection<ENTIDAD>) f3.get(t2);
							c2.remove(object);
						} catch (Exception e) {
							logDao.trace("ERROR AL BORRAR LAS REFERENCIAS AL OBJETO: " + e );
						}
					});
				});
			((Collection)c).clear();
			} catch (Exception e) {
				logDao.trace("ERROR AL BORRAR LAS REFERENCIAS AL OBJETO: " + e );
			}
		});
		try {
			s.beginTransaction();
			s.delete(object);
			s.getTransaction().commit();
			logDao.trace("BORRADO CORRECTAMENTE.");			
		} catch ( Exception e ) {
			logDao.trace("ERROR AL BORRAR EL OBJETO: " + e );
			s.getTransaction().rollback();
		}

	}

	@Override
	public List<ENTIDAD> getAll() {
		logDao.trace("CONSULTANDO TODOS LOS OBJETOS " + claseRepositorio.getSimpleName() + ":");
		try {
			s.beginTransaction();
			logDao.trace("CONSULTADO CORRECTAMENTE.");
			return s.createQuery( "FROM " + claseRepositorio.getSimpleName()).list();
		} catch( Exception e ) {
			logDao.trace("ERROR AL CONSULTAR LA LISTA DE OBJETOS " + claseRepositorio.getSimpleName() + ": " + e );
			return new ArrayList<>();
		}
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

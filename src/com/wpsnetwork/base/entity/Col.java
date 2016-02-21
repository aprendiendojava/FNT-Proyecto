package com.wpsnetwork.base.entity;

import java.util.Collection;
import java.util.Iterator;

public class Col<DTO extends ENTIDAD, ENTIDAD extends Table> implements Collection<ENTIDAD> {
	private Collection<ENTIDAD> a;

	private Col( Collection<DTO> a ) {
		this.a = (Collection<ENTIDAD>) a;
	}
	public static <DTO extends ENTIDAD, ENTIDAD extends Table> Collection<ENTIDAD> getInstance( Collection<DTO> a ) {
		return new Col<>(a);
		
	}
	@Override
	public boolean add(ENTIDAD e) {
		return a.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends ENTIDAD> c) {
		return a.addAll(c);
	}

	@Override
	public void clear() {
		a.clear();
	}

	@Override
	public boolean contains(Object o) {
		return a.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return a.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return a.isEmpty();
	}

	@Override
	public Iterator<ENTIDAD> iterator() {
		return a.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return a.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return a.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return a.retainAll(c);
	}

	@Override
	public int size() {
		return a.size();
	}

	@Override
	public Object[] toArray() {
		return a.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.a.toArray(a);
	}
}

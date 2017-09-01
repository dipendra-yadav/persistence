package com.deependra.persistence.service.common;

import java.io.Serializable;
import java.util.List;

import com.deependra.persistence.dao.common.IOperations;

public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

	protected abstract IOperations<T> getDao();

	// API
	public T findOne(final long id) {
		return getDao().findOne(id);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}

	public void create(final T entity) {
		getDao().create(entity);
	}

	public T update(final T entity) {
		return getDao().update(entity);
	}

	public void delete(final T entity) {
		getDao().delete(entity);
	}

	public void deleteById(final long entityId) {
		getDao().deleteById(entityId);
	}

}
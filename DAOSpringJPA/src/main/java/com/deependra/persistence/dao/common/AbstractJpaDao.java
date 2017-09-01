package com.deependra.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AbstractJpaDao<T extends Serializable> extends AbstractDao<T> implements IOperations<T> {

	@PersistenceContext
	private EntityManager em;

	// API

	public T findOne(final long id) {
		return em.find(clazz, Long.valueOf(id).intValue());
	}

	public List<T> findAll() {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<T> cq = cb.createQuery(clazz);
		final Root<T> rootEntry = cq.from(clazz);
		final CriteriaQuery<T> all = cq.select(rootEntry);
		final TypedQuery<T> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	public void create(final T entity) {
		em.persist(entity);
	}

	public T update(final T entity) {
		em.merge(entity);
		return entity;
	}

	public void delete(final T entity) {
		em.remove(entity);
	}

	public void deleteById(final long entityId) {
		delete(findOne(entityId));
	}

}

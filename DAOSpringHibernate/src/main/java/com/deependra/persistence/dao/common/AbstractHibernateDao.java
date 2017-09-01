package com.deependra.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;

@SuppressWarnings("unchecked")
public class AbstractHibernateDao<T extends Serializable> extends AbstractDao<T> implements IOperations<T> {

	@Autowired
	private SessionFactory sessionFactory;

	// API
	// Operations implemented

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public T findOne(long id) {

		return (T) getCurrentSession().get(clazz, id);
	}

	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public void create(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().saveOrUpdate(entity);

	}

	public T update(T entity) {
		Preconditions.checkNotNull(entity);
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().delete(entity);

	}

	public void deleteById(long entityId) {
		final T entity = findOne(entityId);
		Preconditions.checkState(entity != null);
		delete(entity);

	}

}


//1 we have written a base DAO – an abstract, parametrized DAO which supports the common generic operations 
//  and is meant to be extended for each entity:

//2 the abstract DAO does not extend any Spring template (such as HibernateTemplate). 
//  Instead, the Hibernate SessionFactory is injected directly in the DAO.

//3 to get Hibernate session(contextual Session) from sessionFactory,this.sessionFactory.getCurrentSession();
//4 we are using some Third Party classes -Guava



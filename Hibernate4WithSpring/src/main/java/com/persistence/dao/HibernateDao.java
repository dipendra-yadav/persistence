package com.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.persistence.model.User;

@Repository
public class HibernateDao {

	// injects the raw Hibernate SessionFactory

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();

	}

	/*
	 * An important note here is that this is now the recommended way to use the
	 * Hibernate API – the older HibernateTemplate is no longer included in the
	 * new org.springframework.orm.hibernate4 package as it shouldn’t be used
	 * with Hibernate 4.
	 */

	public void saveUser(User user) {

		getCurrentSession().save(user);

	}

}

package com.deependra.persistence.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.deependra.persistence.dao.IChildDao;
import com.deependra.persistence.dao.common.AbstractHibernateDao;
import com.deependra.persistence.model.Child;


@Component
@Repository
public class ChildDao extends AbstractHibernateDao<Child> implements IChildDao {

	public ChildDao() {

		super();
		
		setClazz(Child.class);
	}

	// API
}

package com.deependra.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.deependra.persistence.dao.IParentDao;
import com.deependra.persistence.dao.common.AbstractHibernateDao;
import com.deependra.persistence.model.Parent;



@Repository("prntdao")
public class ParentDao extends AbstractHibernateDao<Parent> implements IParentDao {

	public ParentDao() {
		super();

		setClazz(Parent.class);
	}

	// API
}

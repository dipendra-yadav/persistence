package com.deependra.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deependra.persistence.dao.IParentDao;
import com.deependra.persistence.dao.common.IOperations;
import com.deependra.persistence.model.Parent;
import com.deependra.persistence.service.IParentService;
import com.deependra.persistence.service.common.AbstractHibernateService;

@Service
public class ParentService extends AbstractHibernateService<Parent> implements IParentService {

	@Autowired
	private IParentDao dao;

	public ParentService() {
		super();
	}

	// API

	@Override
	protected IOperations<Parent> getDao() {
		return dao;
	}

}

package com.deependra.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deependra.persistence.dao.IChildDao;
import com.deependra.persistence.dao.common.IOperations;
import com.deependra.persistence.model.Child;
import com.deependra.persistence.service.IChildService;
import com.deependra.persistence.service.common.AbstractHibernateService;

@Service
public class ChildService extends AbstractHibernateService<Child> implements IChildService {

	@Autowired
	private IChildDao dao;

	public ChildService() {
		super();
	}

	// API
	@Override
	protected IOperations<Child> getDao() {
		return dao;
	}

	
	
}

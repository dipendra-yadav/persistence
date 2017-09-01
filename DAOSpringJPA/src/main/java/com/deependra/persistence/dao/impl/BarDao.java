package com.deependra.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.deependra.persistence.dao.IBarDao;
import com.deependra.persistence.dao.common.AbstractJpaDao;
import com.deependra.persistence.model.Bar;


@Repository("brdao")
public class BarDao extends AbstractJpaDao<Bar> implements IBarDao {

	public BarDao() {
		super();

		setClazz(Bar.class);
	}

	// API

}

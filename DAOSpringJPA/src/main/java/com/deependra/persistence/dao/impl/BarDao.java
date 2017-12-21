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


//1 implement the DAO with Spring and JPA. 
//2 No More Spring Templates:
//    the JpaTemplate and the corresponding JpaDaoSupport have been deprecated in favor of using the native Java Persistence API.
//    Also, both of these classes are only relevant for JPA 1
//    As a consequence, it is now best practice to use the Java Persistence API directly instead of the JpaTemplate.
//
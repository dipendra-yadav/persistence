package com.persistence.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.persistence.model.Foo;



@Component
@Repository
@Transactional
public class FooDao extends AbstractJpaDAO<Foo> implements IFooDao {
	public FooDao() {
		super();

		setClazz(Foo.class);
	}

	// API
	
	
	
}

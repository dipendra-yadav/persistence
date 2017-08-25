package com.persistence.dao;

import com.persistence.model.Foo;

public class FooDao extends AbstractJpaDAO<Foo> implements IFooDao {
	public FooDao() {
		super();

		setClazz(Foo.class);
	}

	// API
}

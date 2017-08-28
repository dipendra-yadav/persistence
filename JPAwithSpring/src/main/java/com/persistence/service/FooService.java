package com.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.persistence.dao.IFooDao;
import com.persistence.model.Foo;

@Component
@Service
public class FooService {

	@Autowired(required=true)
	private IFooDao dao;

	public FooService() {
		super();
	}

	// API

	public void create(final Foo entity) {
		dao.create(entity);
	}

	public Foo findOne(final long id) {
		return dao.findOne(id);
	}

	public List<Foo> findAll() {
		return dao.findAll();
	}

}

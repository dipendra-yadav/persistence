package com.deependra.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deependra.persistence.dao.impl.BarDao;
import com.deependra.persistence.model.Bar;

public class BarTest {

	// artifacts
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Bar bar;

	@Autowired
	static BarDao bardao;

	// prepare artifacts
	@BeforeClass
	static public void initalize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.deependra.*");
		context.refresh();

		// fetch Beans
		bar = context.getBean(Bar.class);
		System.out.println("bar=" + bar);

		bardao = (BarDao) context.getBean("brdao");
		System.out.println("bardao=" + bardao);

	}

	// test case
	@Test
	public void inserBarTestCase() {

		System.out.println("Bar Test Case  is run");
	}

}

package com.deependra.test;

import org.aspectj.asm.IProgramElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deependra.persistence.dao.IParentDao;
import com.deependra.persistence.dao.impl.ParentDao;
import com.deependra.persistence.model.Child;
import com.deependra.persistence.model.Parent;

public class UserTest {

	// artifacts
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Parent parent;

	@Autowired
	static Child child;

	@Autowired
	static ParentDao pdao;

	// prepare artifacts
	@BeforeClass
	static public void initalize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.deependra.*");
		context.refresh();

		// fetch Beans
		parent = context.getBean(Parent.class);
		System.out.println("parent=" + parent);

		child = context.getBean(Child.class);
		System.out.println("child=" + child);

		pdao = (ParentDao) context.getBean("prntdao");
		System.out.println("parentDao=" + pdao);

	}

	// test case
	@Test
	public void inserUserTestCase() {

		/*
		 * child.setId(1);
		 * 
		 * parent.setId(1); parent.setChild(child);
		 * 
		 * pdao.create(parent);
		 */

	}

}

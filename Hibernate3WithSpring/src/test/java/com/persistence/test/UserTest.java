package com.persistence.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.persistence.dao.HibernateDao;
import com.persistence.model.User;

//Unit Test
public class UserTest  {
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static User user;

	@Autowired
	static HibernateDao hibernateDao;

	@BeforeClass
	static public void initalize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.persistence.*");
		context.refresh();

		// fecth Beans
		user = context.getBean(User.class);
		System.out.println("user=" + user);

		hibernateDao = (HibernateDao) context.getBean("hibernateDao");
		System.out.println("UserDAO=" + hibernateDao);

	}

	@Test
	public void inserUserTestCase() {

		user.setEmployee_Id("30432");
		user.setUser_name("Manoj");
		
		assertEquals("Record Inserted!!", "Manoj", user.getUser_name());

	}

}

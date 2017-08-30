package com.springdatajpa.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.springdatajpa.config.PersistenceConfig;
import com.springdatajpa.config.SpringWebConfig;
import com.springdatajpa.dao.UserRepository;
import com.springdatajpa.model.User;

//@WebAppConfiguration
@ContextConfiguration(classes = { SpringWebConfig.class, PersistenceConfig.class })
public class UserTest {

	// artifacts
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static User user;

	@Autowired
	static UserRepository userRepository;

	// prepare artifacts
	@BeforeClass
	static public void initalize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.springdatajpa.*");
		context.refresh();

		// fecth Beans
		user = context.getBean(User.class);
		System.out.println("user=" + user);

		userRepository = (UserRepository) context.getBean("userRepository");
		System.out.println("UserDAO=" + userRepository);

	}

	// test case
	@Test
	public void inserUserTestCase() {

		user.setFirstName("deependra");
		user.setLastName("yadav");
		user.setAge(25);
		user.setEmail("dipendra.yadav@niit.com");

		assertEquals("Record Inserted!!", "deependra", user.getFirstName());

	}

}

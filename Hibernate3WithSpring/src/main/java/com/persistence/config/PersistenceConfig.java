package com.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.persistence.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.persistence.*")
@PropertySource(value = { "classpath:persistence-mysql.properties" })
public class PersistenceConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource DataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}

	public Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.globally_quoted_identifiers", "true");

		return prop;
	}

	@SuppressWarnings("deprecation")
	@Bean
	public AnnotationSessionFactoryBean sessionFactory() {
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		sessionFactory.setDataSource(DataSource());
		sessionFactory.setAnnotatedClasses(User.class);
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@SuppressWarnings("deprecation")
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}

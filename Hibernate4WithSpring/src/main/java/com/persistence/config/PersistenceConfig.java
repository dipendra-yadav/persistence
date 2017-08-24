package com.persistence.config;

import javax.sql.DataSource;

import org.hibernate.metamodel.relational.BasicAuxiliaryDatabaseObjectImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
@ComponentScan({ "com.persistence.config" })
public class PersistenceConfig {

	@Autowired
	   private Environment env;
	 
	   @Bean
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(restDataSource());
	      sessionFactory.setPackagesToScan(
	        new String[] { "org.baeldung.spring.persistence.model" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	 
	      return sessionFactory;
	   }
	
	
	
	
	@Bean
	   public DataSource restDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	      dataSource.setUrl(env.getProperty("jdbc.url"));
	      dataSource.setUsername(env.getProperty("jdbc.user"));
	      dataSource.setPassword(env.getProperty("jdbc.pass"));
	 
	      return dataSource;
	   }	
	 
	   @Bean
	   @Autowired
	   public HibernateTransactionManager transactionManager(
	     SessionFactory sessionFactory) {
	  
	      HibernateTransactionManager txManager
	       = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	 
	      return txManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	

}

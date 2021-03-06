package com.persistence.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
/*
 * Spring 3.1 introduces the @EnableTransactionManagement annotation to be used
 * in on @Configuration classes and enable transactional support:
 */

//There are two distinct ways to configure Transactions � annotations and AOP � 

@PropertySource({ "classpath:persistence-jndi.properties" })
@ComponentScan({ "com.persistence" })
@EnableJpaRepositories(basePackages = "com.persistence.dao")
public class PersistenceJNDIConfig {

	@Autowired
	private Environment env;

	public PersistenceJNDIConfig() {
		super();
	}

	@Bean
	public DataSource dataSource() throws NamingException {
		return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.persistence.model" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	//Platform -specific exception are turned into  spring's unchecked Data excess Exception
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	/*public BeanPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}*/


	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		// hibernateProperties.setProperty("hibernate.cache.use_second_level_cache",
		// "false");
		return hibernateProperties;
	}
}
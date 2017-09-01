package com.deependra.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.deependra.persistence.dao.IParentDao;
import com.deependra.persistence.dao.common.AbstractHibernateDao;
import com.deependra.persistence.model.Parent;

@Repository("prntdao")
public class ParentDao extends AbstractHibernateDao<Parent> implements IParentDao {

	public ParentDao() {
		super();

		setClazz(Parent.class);
	}

	// API
}

// 1  implement the DAO with Spring and Hibernate.
// 2 
//    the Spring HibernateTemplate is no longer necessary to manage the Hibernate
//    Session.
//    It is now possible to make use of contextual sessions – sessions managed
//    directly by Hibernate and active throughout the scope of a transaction.

// 3  As a consequence, it is now best practice to use the Hibernate API directly
//    instead of the HibernateTemplate,which will effectively decouple the DAO layer implementation from Spring
//    entirely.

// 4  Conclusion: 
//    The reasons to stop relying on templates for the DAO layer was discussed, 
//    as well as possible pitfalls of configuring Spring to manage transactions and the Hibernate Session. 
//    The final result is a lightweight, clean DAO implementation, with almost no compile-time reliance on Spring.
      
/*   Questions? 
     what other way to pass class Type other than this constructor
     his.persistentClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

     so there’s no need for setting the class on the constructor.
*/

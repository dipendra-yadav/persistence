/*The Spring Data generated DAO – No More DAO Implementations*/
//1  the DAO layer usually consists of a lot of boilerplate code that can and should be simplified.
//2  The advantages of such a simplification are many: 
//   a decrease in the number of artifacts that need to be defined and maintained, 
//   consistency of data access patterns and consistency of configuration.
//3  Spring Data takes this simplification one step forward and  makes it possible to remove the DAO implementations entirely 
//–  the interface of the DAO is now the only artifact that needs to be explicitly defined.



//4  In order to start leveraging the Spring Data programming model with JPA, a DAO interface needs to extend 
//   the JPA specific Repository interface – JpaRepository. This will enable Spring Data to find this interface and automatically create an implementation for it.


//5  By extending the interface we get the most relevant CRUD methods for standard data access 

//6 Spring Data also takes advantage of the Spring support for the JPA @PersistenceContext annotation which it uses to wire the EntityManager into the Spring factory bean 
//  responsible for creating the actual DAO implementations – JpaRepositoryFactoryBean.

//7 Transaction Configuration:
//  The actual implementation of the Spring Data managed DAO is indeed hidden since we don’t work with it directly. However – it is a simple enough implementation – the SimpleJpaRepository –
//  which defines transaction semantics using annotations.

//8 Exception Translation is Alive and Well:
   // The question is now – since we’re not using the default Spring ORM templates (JpaTemplate, HibernateTemplate)
   // – are we losing exception translation by using Spring Data JPA?-Are we not going to get our JPA exceptions 
   // translated to Spring’s DataAccessException hierarchy?


//9 Conclusion:

   //This snippte covered the configuration and implementation of the persistence layer with Spring 4, JPA 2 and Spring Data JPA (part of the Spring Data umbrella project), using both XML and Java based configuration.

   //The various method of defining more advanced custom queries are discussed, as well as a configuration with the new jpa namespace and transactional semantics. The final result is a new and elegant way 2  data access with Spring, with almost no actual implementation work.



package com.springdatajpa.dao;





import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

package com.persistence.multiple.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistence.multiple.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

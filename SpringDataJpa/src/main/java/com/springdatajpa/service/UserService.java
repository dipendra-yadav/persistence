package com.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springdatajpa.dao.UserRepository;
import com.springdatajpa.model.User;


@Component
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.save(user);

	}

}

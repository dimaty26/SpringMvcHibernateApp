package com.zmeevsky.springdemo.service;

import com.zmeevsky.springdemo.entity.User;
import com.zmeevsky.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {

		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(list::add);

		return list;
	}

	@Override
	public void saveUser(User theUser) {

		try {
			userRepository.save(theUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int theId) {
		return userRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {

		try {
			userRepository.deleteById(theId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






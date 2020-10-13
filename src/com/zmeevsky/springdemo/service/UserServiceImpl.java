package com.zmeevsky.springdemo.service;

import com.zmeevsky.springdemo.dao.UserDao;
import com.zmeevsky.springdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUsers() {
		return new ArrayList<>(userDao.getUsers());
	}

	@Override
	public void saveUser(User theUser) {
		userDao.saveUser(theUser);
	}

	@Override
	public User getUser(int theId) {
		return userDao.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDao.deleteUser(theId);
	}

	@Override
	public List<User> searchUsers(String theSearchName) {
		return userDao.searchUsers(theSearchName);
	}
}






package com.zmeevsky.springdemo.service;

import com.zmeevsky.springdemo.entity.User;

import java.util.List;

public interface UserService {

	List<User> getUsers();

	void saveUser(User theUser);

	User getUser(int theId);

	void deleteUser(int theId);

	List<User> searchUsers(String theSearchName);
}

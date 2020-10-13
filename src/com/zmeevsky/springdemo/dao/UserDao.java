package com.zmeevsky.springdemo.dao;

import com.zmeevsky.springdemo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    List<User> searchUsers(String theSearchName);
}

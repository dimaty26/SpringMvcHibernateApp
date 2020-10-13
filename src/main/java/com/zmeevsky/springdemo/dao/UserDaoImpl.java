package com.zmeevsky.springdemo.dao;

import com.zmeevsky.springdemo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        entityManager.remove(user);
    }

    @Override
    public List<User> searchUsers(String theSearchName) {

        Query query = null;

        if (theSearchName != null && theSearchName.trim().length() > 0) {

            //search for firstName or lastName ... case insensitive
            query = entityManager.createQuery("from User where lower(firstName) " +
                    "like :theName or lower(lastName) like :theName", User.class);
            query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            //theSearchName is empty ... so just get all customers
            query = entityManager.createQuery("from User", User.class);
        }

        return query.getResultList();
    }
}

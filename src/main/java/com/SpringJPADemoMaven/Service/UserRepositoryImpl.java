package com.SpringJPADemoMaven.Service;

import com.SpringJPADemoMaven.Entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public User saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    public User findUserById(Long id) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class);
        query.setParameter(1, id); // Set the positional parameter
        return query.getSingleResult();
    }

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findAllUsingNamedQuery", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> findUserByName(String name) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findUserByName", User.class);
        query.setParameter("name", name); // Use named parameter
        return query.getResultList();
    }

    @Override
    public List<User> findUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findUserByEmail", User.class);
        query.setParameter("email", email); // Use named parameter
        return query.getResultList();
    }
//    @Override
//    public List<User> findUsersByStatus(String status) {
//        TypedQuery<User> query = entityManager.createNamedQuery("User.findByStatus", User.class);
//        query.setParameter(1, status); // Set the positional parameter
//        return query.getResultList();
//    }
}

package com.SpringJPADemoMaven.Service;

import com.SpringJPADemoMaven.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    public User saveUser(User user) {
        return userRepositoryCustom.saveUser(user);
    }

    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(userRepositoryCustom.findUserById(id));
    }
    public List<User> findUsersByUsername(String name) {
        return userRepositoryCustom.findUserByName(name);
    }

    public List<User> findUsersByEmail(String email) {
        return userRepositoryCustom.findUserByEmail(email);
    }
    public List<User> findAllUsers() {
        return userRepositoryCustom.findAllUsers();
    }

    public void deleteUser(Long id) {
        userRepositoryCustom.deleteUser(id);
    }
    
}

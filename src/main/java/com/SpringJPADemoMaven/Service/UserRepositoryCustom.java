package com.SpringJPADemoMaven.Service;

import com.SpringJPADemoMaven.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {
    User saveUser(User user);
    User findUserById(Long id);
    List<User> findAllUsers();
    void deleteUser(Long id);
    List<User> findUserByName(String name);
    List<User> findUserByEmail(String emai);
	//List<User> findUsersByStatus(String status);
}

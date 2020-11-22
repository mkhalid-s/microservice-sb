package com.bootcamp.rest.ws.restwebservices.service;

import com.bootcamp.rest.ws.restwebservices.bean.User;
import com.bootcamp.rest.ws.restwebservices.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao = new UserDao();

    public List<User> retrieveAllUser() {
        return userDao.findAll();
    }


    public User findUserById(Integer id) {
        return userDao.findByUserId(id);
    }


    public User saveUser(User u) {
        return userDao.save(u);
    }
}

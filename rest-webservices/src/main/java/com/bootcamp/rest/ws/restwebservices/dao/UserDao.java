package com.bootcamp.rest.ws.restwebservices.dao;

import com.bootcamp.rest.ws.restwebservices.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Alex", new Date()));
        users.add(new User(2, "John", new Date()));
        users.add(new User(3, "Ray", new Date()));
        users.add(new User(4, "Matt", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findByUserId(Integer id) {
        if (id != null && id <= users.size()) {
            for (User u : users
            ) {
                if (u.getId().equals(id)) {
                    return u;
                }
            }

        }
        return null;
    }

    public User save(User user) {
        if (user != null && user.getId() != null) {
            users.add(user);
        } else if (user != null) {
            user.setId(users.size() + 1);
            users.add(user);
        }
        return user;
    }
}

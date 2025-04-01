package org.example.dao;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    // 模拟数据库存储
    private static final Map<String, User> userDatabase = new HashMap<>();

    static {
        userDatabase.put("admin", new User("admin", "123456"));
        userDatabase.put("user1", new User("user1", "password"));
    }

    public User findByUsername(String username) {
        return userDatabase.get(username);
    }
} 
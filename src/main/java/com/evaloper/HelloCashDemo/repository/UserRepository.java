package com.evaloper.HelloCashDemo.repository;

import com.evaloper.HelloCashDemo.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, UserEntity> users = new HashMap<>();

    public void save(UserEntity user) {
        users.put(user.getPhoneNumber(), user);
    }

    public UserEntity findByPhoneNumber(String phoneNumber) {
        return users.get(phoneNumber);
    }
}

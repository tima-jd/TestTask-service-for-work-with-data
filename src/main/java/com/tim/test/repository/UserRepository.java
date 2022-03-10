package com.tim.test.repository;

import com.tim.test.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    List<User> list = new ArrayList<>();

    public List<User> listUsers(){
        return list;
    }
}

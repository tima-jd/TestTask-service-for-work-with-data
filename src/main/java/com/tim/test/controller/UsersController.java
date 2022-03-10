package com.tim.test.controller;

import com.tim.test.dao.UserDAO;
import com.tim.test.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsersController {

    private final UserDAO userDAO;

    @PutMapping("/setinfo")
    public User save(@RequestBody User user) {
        return userDAO.save(user);
    }

    @GetMapping("/levelinfo/{levelId}")
    public List<User> getByLevelId(@PathVariable("levelId") int levelId) {
        return userDAO.getByLevelId(levelId);
    }

    @GetMapping("/userinfo/{userId}")
    public List<User> getByUserId(@PathVariable("userId") int userId) {
        return userDAO.getByUserId(userId);
    }
}

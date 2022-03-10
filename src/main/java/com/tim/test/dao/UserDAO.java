package com.tim.test.dao;

import com.tim.test.repository.UserRepository;
import com.tim.test.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@AllArgsConstructor
@Component
public class UserDAO {

    private UserRepository users;

    public User save(User user) {
        users.listUsers().add(user);
        log.info("new user = {} added", user);
        return user;
    }

    public List<User> getByLevelId(int levelId) {
        log.info("Users: {}", users.listUsers());
        log.info("returned top 20 users by level_id");
        return users.listUsers().stream()
                .filter((user -> user.getLevel_id() == levelId))
                .sorted(Comparator.comparingInt(User::getResult).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    public List<User> getByUserId(int userId) {
        log.info("Users: {}", users.listUsers());
        log.info("returned top 20 users by user_id");
        return users.listUsers().stream()
                .filter(user -> user.getUser_id() == userId)
                .sorted(Comparator.comparingInt(User::getResult).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }
}

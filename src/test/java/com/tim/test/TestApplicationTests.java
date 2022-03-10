package com.tim.test;

import com.tim.test.dao.UserDAO;
import com.tim.test.repository.UserRepository;
import com.tim.test.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TestApplicationTests {

    UserDAO userDAO;
    List<User> user = new ArrayList();

    @Mock
    UserRepository users;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO(users);
    }

    void addingUsers() {
        user.add(new User(1, 1, 55));
        user.add(new User(1, 2, 8));
        user.add(new User(1, 3, 15));
        user.add(new User(2, 3, 22));
    }

    @Test
    void getByLevelId() {
        addingUsers();
        when(users.listUsers()).thenReturn(user);

        List<User> expected = userDAO.getByLevelId(3);

        List<User> actual = new ArrayList<>();
        actual.add(new User(2, 3, 22));
        actual.add(new User(1, 3, 15));

        assertEquals(expected, actual);
    }

    @Test
    void getByUserId() {
        addingUsers();
        when(users.listUsers()).thenReturn(user);

        List<User> expected = userDAO.getByUserId(1);

        List<User> actual = new ArrayList<>();
        actual.add(new User(1, 1, 55));
        actual.add(new User(1, 3, 15));
        actual.add(new User(1, 2, 8));

        assertEquals(expected, actual);
    }
}

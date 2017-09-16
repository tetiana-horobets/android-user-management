package com.example.tetiana.user_management;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserRepositoryTest {

    @Test
    public void findsAllUsers() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-users.json");
        UserRepository userRepository = new UserRepository(inputStream);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(2, users.size());
        Assert.assertEquals(1, users.get(0).getId());
        Assert.assertEquals("Mark", users.get(0).getName());
        Assert.assertEquals(2, users.get(1).getId());
        Assert.assertEquals("Emilia", users.get(1).getName());
    }

    @Test
    public void findsAllUsersDifferentName() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-users-different-name.json");
        UserRepository userRepository = new UserRepository(inputStream);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void findsAllUsersInvalidId() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-users-invalid-id.json");
        UserRepository userRepository = new UserRepository(inputStream);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(2, users.get(0).getId());
        Assert.assertEquals("Emilia", users.get(0).getName());
    }

    @Test
    public void findsAllUsersEmpty() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-users-empty.json");
        UserRepository userRepository = new UserRepository(inputStream);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void findsAllUsersCount() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-users-count.json");
        UserRepository userRepository = new UserRepository(inputStream);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(2, users.size());
        Assert.assertEquals(1, users.get(0).getId());
        Assert.assertEquals("Mark", users.get(0).getName());
        Assert.assertEquals(2, users.get(1).getId());
        Assert.assertEquals("Emilia", users.get(1).getName());
    }
}

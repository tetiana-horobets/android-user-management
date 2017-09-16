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
        Assert.assertEquals("Mark", users.get(0).getName());
        Assert.assertEquals("Emilia", users.get(1).getName());
    }
}

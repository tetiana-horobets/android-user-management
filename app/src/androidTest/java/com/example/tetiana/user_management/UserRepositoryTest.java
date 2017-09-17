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

    @Test
    public void findUsersById() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-user-details.json");
        UserRepository userRepository = new UserRepository(inputStream);
        User user = userRepository.findUsersById(2);
        Assert.assertEquals(2, user.getId());
        Assert.assertEquals("John", user.getName());
        Assert.assertEquals("john@gmail.com", user.getEmail());
        Assert.assertEquals(34, user.getAge());
        Assert.assertEquals(false, user.isFemale());
        Assert.assertEquals(5, user.getHobbies().size());
        Assert.assertEquals("Swimming", user.getHobbies().get(0));
        Assert.assertEquals("Driving", user.getHobbies().get(1));
        Assert.assertEquals("Singing", user.getHobbies().get(2));
        Assert.assertEquals("Playing piano", user.getHobbies().get(3));
        Assert.assertEquals("making funny noises", user.getHobbies().get(4));
        Assert.assertEquals("http://lorempixel.com/output/people-q-c-200-200-2.jpg", user.getImage());
        Assert.assertEquals("http://lorempixel.com/output/animals-q-c-600-200-2.jpg", user.getBack());
    }

    @Test
    public void findUsersByIdDifferentName() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-user-details-different-name.json");
        UserRepository userRepository = new UserRepository(inputStream);
        User user = userRepository.findUsersById(2);
        Assert.assertNull(user);
    }

    @Test
    public void findUsersByIdEmpty() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-user-details-empty.json");
        UserRepository userRepository = new UserRepository(inputStream);
        User user = userRepository.findUsersById(2);
        Assert.assertNull(user);
    }
}

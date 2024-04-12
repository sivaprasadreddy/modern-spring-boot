package com.sivalabs.modernboot.httpclient;

import com.sivalabs.modernboot.AbstractIntegrationTest;
import com.sivalabs.modernboot.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JsonPlaceHolderHttpClientTest extends AbstractIntegrationTest {

    @Autowired
    JsonPlaceHolderHttpClient client;

    @Test
    void findAll() {
        List<User> users = client.findAllUsers();
        assertThat(users).isNotEmpty();
        System.out.println("users = " + users);
    }

    @Test
    void findById() {
        User user = client.findUserById(1L);
        assertThat(user).isNotNull();
        System.out.println("user = " + user);
    }

    @Test
    void create() {
        User user = new User(11L, "testuser", "testuser", "testuser@gmail.com", "1234567890", "https://testuser.com");
        User createdUser = client.createUser(user);
        assertThat(createdUser).isNotNull();
        System.out.println("createdUser = " + createdUser);
    }

    @Test
    void delete() {
        client.deleteUser(11L);
    }
}
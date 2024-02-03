package com.sivalabs.modernboot.httpclient;

import com.sivalabs.modernboot.ContainersConfig;
import com.sivalabs.modernboot.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(ContainersConfig.class)
class JsonPlaceHolderHttpClientTest {

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
        User user = client.findUserById(1);
        assertThat(user).isNotNull();
        System.out.println("user = " + user);
    }

    @Test
    void create() {
        User user = new User(11, "testuser", "testuser", "testuser@gmail.com", "1234567890", "https://testuser.com");
        User createdUser = client.createUser(user);
        assertThat(createdUser).isNotNull();
        System.out.println("createdUser = " + createdUser);
    }

    @Test
    void delete() {
        client.deleteUser(11);
    }
}
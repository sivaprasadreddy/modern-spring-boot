package com.sivalabs.modernboot.restclient;

import com.sivalabs.modernboot.AbstractIntegrationTest;
import com.sivalabs.modernboot.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class JsonPlaceHolderApiClientTests extends AbstractIntegrationTest {

    @Autowired
    private JsonPlaceHolderApiClient jsonPlaceHolderApiClient;

    @Test
    void shouldGetAllUsers() {
        List<User> users = jsonPlaceHolderApiClient.getAllUsers();
        System.out.println("users = " + users);
    }

    @Test
    void shouldGetUserById() {
        User user = jsonPlaceHolderApiClient.getUserById(1);
        System.out.println("user = " + user);
    }
}

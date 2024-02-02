package com.sivalabs.modernboot.httpclient;

import com.sivalabs.modernboot.ContainersConfig;
import com.sivalabs.modernboot.models.User.Address;
import com.sivalabs.modernboot.models.User.Company;
import com.sivalabs.modernboot.models.User.Geo;
import com.sivalabs.modernboot.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(ContainersConfig.class)
class JsonPlaceHolderHttpClientTest {

    @Autowired
    JsonPlaceHolderHttpClient client;

    @Test
    void findAll() {
        List<User> users = client.findAllUsers();
        System.out.println("users = " + users);
    }

    @Test
    void findById() {
        User user = client.findUserById(1);
        System.out.println("user = " + user);
    }

    @Test
    void create() {
        Address address = new Address("test street", "test city", "12345-6789", "12345",
                new Geo("1.1", "2.2"));
        Company company = new Company("test company", "test catch phrase", "test");
        User user = new User(11, "testuser", "asdf", "testuser@gmail.com",
                address, "1234567890", "http://test.com", company);
        User createdUser = client.createUser(user);
        System.out.println("createdUser = " + createdUser);
    }

    @Test
    void delete() {
        client.deleteUser(11);
    }
}
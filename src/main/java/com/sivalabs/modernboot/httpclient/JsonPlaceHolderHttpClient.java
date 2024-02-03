package com.sivalabs.modernboot.httpclient;

import com.sivalabs.modernboot.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

// https://jsonplaceholder.typicode.com/users

public interface JsonPlaceHolderHttpClient {
    @GetExchange("/users")
    List<User> findAllUsers();

    @GetExchange("/users/{id}")
    User findUserById(@PathVariable Integer id);

    @PostExchange("/users")
    User createUser(@RequestBody User user);

    @DeleteExchange("/users/{id}")
    void deleteUser(@PathVariable Integer id);
}

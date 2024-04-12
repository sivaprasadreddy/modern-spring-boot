package com.sivalabs.modernboot.api;

import com.sivalabs.modernboot.models.User;
import com.sivalabs.modernboot.restclient.JsonPlaceHolderApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final JsonPlaceHolderApiClient client;

    UserController(JsonPlaceHolderApiClient client) {
        this.client = client;
    }

    @GetMapping("/{id}")
    User fetchUserById(@PathVariable Long id) {
        log.info("Thread:{}, Loading user by id: {}",
                Thread.currentThread().getName(), id);
        return client.getUserById(id);
    }
}

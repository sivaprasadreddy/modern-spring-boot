package com.sivalabs.modernboot.jdbcclient;

import com.sivalabs.modernboot.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Disabled
class UserRepositoryTest {
    @Autowired
    JdbcClient jdbcClient;

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository(jdbcClient);
    }

    @Test
    void shouldCreateUser() {
        User user = new User(null, "Siva", "siva", "siva@gmail.com", "99999999", "sivalabs.in");
        Long id = userRepository.save(user);
        assertThat(id).isNotNull();
    }
}
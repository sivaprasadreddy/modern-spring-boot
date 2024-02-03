package com.sivalabs.modernboot.jdbcclient;

import com.sivalabs.modernboot.models.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
class UserRepository {
    private final JdbcClient jdbcClient;

    public UserRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Transactional
    public Long save(User user) {
        String sql = """
                    insert into users(name, username, email, phone, website)
                    values(:name, :username, :email, :phone, :website)
                    ON CONFLICT DO NOTHING returning id
                    """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param("name", user.name())
                .param("username", user.username())
                .param("email", user.email())
                .param("phone", user.phone())
                .param("website", user.website())
                .update(keyHolder);
        return keyHolder.getKeyAs(Long.class);
    }
}

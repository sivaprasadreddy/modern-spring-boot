package com.sivalabs.modernboot.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    RestClient restClient(@Value("${PLACEHOLDER_API_BASE_URI}") String baseURI) {
        return RestClient.create(baseURI);
    }
}

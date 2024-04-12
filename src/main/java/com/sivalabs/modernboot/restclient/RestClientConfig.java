package com.sivalabs.modernboot.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class RestClientConfig {

    @Bean
    RestClient restClient(@Value("${placeholder_api_base_uri}") String baseURI) {
        return RestClient
                .builder()
                .baseUrl(baseURI)
                .build();
    }
}

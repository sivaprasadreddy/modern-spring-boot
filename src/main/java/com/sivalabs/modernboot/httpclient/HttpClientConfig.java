package com.sivalabs.modernboot.httpclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {

    @Bean
    JsonPlaceHolderHttpClient jsonPlaceholderService(
            @Value("${PLACEHOLDER_API_BASE_URI}") String baseURI) {
        RestClient restClient = RestClient.create(baseURI);
        HttpServiceProxyFactory factory =
                HttpServiceProxyFactory
                        .builderFor(RestClientAdapter.create(restClient))
                        .build();
        return factory.createClient(JsonPlaceHolderHttpClient.class);
    }
}

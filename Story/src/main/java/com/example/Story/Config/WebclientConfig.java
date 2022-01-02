package com.example.Story.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration

public class WebclientConfig {

    @Bean
    public WebClient webclient()    {

        return WebClient.builder()

                .baseUrl("https://localhost:8082/story")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    }

}

package com.gmstandingssim.gmstandingsapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@Slf4j
public class GmPlayersController {
    private String grandmastersApiEndpoint = "https://playhearthstone.com/en-us/api/esports/schedule/grandmasters";

    Logger logger = LoggerFactory.getLogger(GmPlayersController.class);

    @GetMapping("/players")
    public ResponseEntity greeting() {
        logger.info("Route /players called");

        WebClient grandmastersClient =
                WebClient
                .builder()
                .baseUrl(grandmastersApiEndpoint)
                .build();

        WebClient.RequestHeadersSpec<?> gmGetRequest = grandmastersClient.get().uri("");

        String response = gmGetRequest.retrieve().bodyToMono(String.class).block();

        return ResponseEntity.ok().body(response);
    }
}
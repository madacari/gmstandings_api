package com.gmstandingssim.gmstandingsapi.controllers;

import com.gmstandingssim.gmstandingsapi.dtos.GmApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@Slf4j
public class GmPlayersController {
    private String grandmastersApiEndpoint = "https://playhearthstone.com/en-us/api/esports/schedule/grandmasters";
    private String simpleEndpoint = "https://gturnquist-quoters.cfapps.io/api/random";

    Logger logger = LoggerFactory.getLogger(GmPlayersController.class);

    @GetMapping("/players")
    public ResponseEntity retrievePlayers() {
        logger.info("Route /players called");

        WebClient grandmastersClient =
                WebClient
                .builder()
                .baseUrl(grandmastersApiEndpoint)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        WebClient.RequestHeadersSpec<?> gmGetRequest = grandmastersClient.get().uri("");

        GmApiResponseDTO response = gmGetRequest.retrieve().bodyToMono(GmApiResponseDTO.class).block();
//        Quote response = gmGetRequest.retrieve().bodyToMono(Quote.class).block();

        logger.info(String.format("%s",response));

        return ResponseEntity.ok().body(response);
    }
}
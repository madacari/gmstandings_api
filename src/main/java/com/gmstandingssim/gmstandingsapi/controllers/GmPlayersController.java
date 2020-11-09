package com.gmstandingssim.gmstandingsapi.controllers;

import com.gmstandingssim.gmstandingsapi.dtos.GmApiRequestDTO;
import com.gmstandingssim.gmstandingsapi.dtos.GmApiResponseDTO;
import com.gmstandingssim.gmstandingsapi.services.GmPlayersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequiredArgsConstructor
@Slf4j
public class GmPlayersController {
    private String grandmastersApiEndpoint = "https://playhearthstone.com/en-us/api/esports/schedule/grandmasters";

    private final GmPlayersService gmPlayersService;

    Logger logger = LoggerFactory.getLogger(GmPlayersController.class);

    @GetMapping("/tournament-data")
    public ResponseEntity retrievePlayers(@RequestParam(required = false, name="season") String season,
                                          @RequestParam(required = false, name="year") String year) {
        logger.info("Route /tournament-data called");
        logger.info(String.format("%s %s",season, year));

        WebClient grandmastersClient =
                WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                            .codecs(configurer -> configurer
                            .defaultCodecs()
                            .maxInMemorySize(5 * 1024 * 1024))
                            .build())
                .baseUrl(grandmastersApiEndpoint)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        String gmRequestUri = gmPlayersService.getRequestUri(season, year);

        WebClient.RequestHeadersSpec<?> gmGetRequest =
                grandmastersClient
                        .get()
                        .uri(gmRequestUri);

        GmApiResponseDTO gmApiResponseDTO = gmGetRequest.retrieve().bodyToMono(GmApiResponseDTO.class).block();

        return ResponseEntity.ok().body(gmApiResponseDTO);
    }
}
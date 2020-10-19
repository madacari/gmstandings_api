package com.gmstandingssim.gmstandingsapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class GmPlayersController {

    private static final String template = "Hello, %s!";
    Logger logger = LoggerFactory.getLogger(GmPlayersController.class);

    @GetMapping("/players")
    public ResponseEntity greeting() {
        logger.info("Route /players called");
        return ResponseEntity.ok().build();
    }
}
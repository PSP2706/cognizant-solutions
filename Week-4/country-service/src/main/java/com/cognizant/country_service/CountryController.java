package com.cognizant.country_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // Step 1: Handle basic POST with no payload
    @PostMapping
    public void addCountry() {
        LOGGER.info("Start");
    }

    // Step 2: Handle POST with request body
    @PostMapping("/add")
    public Country addCountry(@RequestBody Country country) {
        LOGGER.info("Start - Payload received: {}", country);
        return country;
    }
}

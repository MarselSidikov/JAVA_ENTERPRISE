package ru.itis.services.countries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.services.countries.dto.FlagDto;
import ru.itis.services.countries.service.CountriesService;

/**
 * 07.04.2018
 * CountriesController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class CountriesController {

    @Autowired
    private CountriesService service;

    @GetMapping("countries/{country-title}")
    public ResponseEntity<FlagDto> getFlagOfCountry(@PathVariable("country-title") String title) {
        return ResponseEntity.ok(service.getFlagOfCountry(title));
    }
}

package ru.itis.services.countries.service;

import ru.itis.services.countries.dto.FlagDto;

/**
 * 07.04.2018
 * CountriesService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CountriesService {
    FlagDto getFlagOfCountry(String title);
}

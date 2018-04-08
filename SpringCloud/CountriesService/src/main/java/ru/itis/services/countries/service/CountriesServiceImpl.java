package ru.itis.services.countries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.services.countries.dto.FlagDto;

/**
 * 07.04.2018
 * CountriesServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class CountriesServiceImpl implements CountriesService {
    @Autowired
    private RestTemplate template;

    @Value("${restcountries.api.url}")
    private String restCountriesApiUrl;

    @Value("${restcountries.api.fields}")
    private String restCountriesFields;

    @Override
    public FlagDto getFlagOfCountry(String title) {
        String request = restCountriesApiUrl + title + "?fields=" + restCountriesFields;
        System.out.println(request);
        return template.getForEntity(request, FlagDto[].class).getBody()[0];
    }
}

package ru.itis.services.cats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.services.cats.dto.CatDto;

/**
 * 07.04.2018
 * CatsService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class CatsServiceImpl implements CatsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cats.get.request.url}")
    private String catsGetRequestUrl;

    @Override
    public CatDto getCat() {
        return restTemplate.getForEntity(catsGetRequestUrl, CatDto[].class).getBody()[0];
    }
}

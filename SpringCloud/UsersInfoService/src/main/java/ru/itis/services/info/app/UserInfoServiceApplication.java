package ru.itis.services.info.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.itis.services.info.dto.*;

/**
 * 07.04.2018
 * CountriesServiceApplication
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@ComponentScan("ru.itis.services.info")
@RestController
@EnableEurekaClient
public class UserInfoServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/about/{user-id}")
    public ResponseEntity<InfoUserDto> getInfoAbout(@PathVariable("user-id") Long userId) {
        RestTemplate template = restTemplate();
        VkUser vkUser = template.getForEntity("http://VK-SERVICE/users/" + userId, VkUser.class).getBody();
        FlagDto flagDto = template.getForEntity("http://COUNTRIES-SERVICE/countries/" + vkUser.getCountry().getTitle(), FlagDto.class).getBody();
        return ResponseEntity.ok(InfoUserDto.builder()
                .flagUrl(flagDto.getFlag())
                .userName(vkUser.getFirstName())
                .build());
    }

    public static void main(String[] args) {
        SpringApplication.run(UserInfoServiceApplication.class, args);
    }
}

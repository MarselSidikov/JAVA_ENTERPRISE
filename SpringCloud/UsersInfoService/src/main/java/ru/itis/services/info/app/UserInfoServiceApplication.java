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
import org.xmlpull.v1.XmlPullParserException;
import ru.itis.services.info.dto.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

/**
 * 07.04.2018
 * CountriesServiceApplication
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan("ru.itis.services.info")
@RestController
@EnableEurekaClient
public class UserInfoServiceApplication {

    @Bean
    public Docket api() throws IOException, XmlPullParserException {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.itis.services.info.app"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("info/{user-id}")
    public ResponseEntity<InfoUserDto> getInfoAbout(@PathVariable("user-id") Long userId) {
        RestTemplate template = restTemplate();
        VkUser vkUser = template.getForEntity("http://USER/users/" + userId, VkUser.class).getBody();
        FlagDto flagDto = template.getForEntity("http://COUNTRY/countries/" + vkUser.getCountry().getTitle(), FlagDto.class).getBody();
        return ResponseEntity.ok(InfoUserDto.builder()
                .flagUrl(flagDto.getFlag())
                .userName(vkUser.getFirstName())
                .build());
    }

    public static void main(String[] args) {
        SpringApplication.run(UserInfoServiceApplication.class, args);
    }
}

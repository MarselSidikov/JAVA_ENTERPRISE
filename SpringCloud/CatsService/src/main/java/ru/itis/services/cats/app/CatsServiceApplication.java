package ru.itis.services.cats.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.xmlpull.v1.XmlPullParserException;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

/**
 * 07.04.2018
 * VkServiceApplication
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan("ru.itis.services.cats")
@EnableEurekaClient
public class CatsServiceApplication {

    @Bean
    public Docket api() throws IOException, XmlPullParserException {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.itis.services.cats.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CatsServiceApplication.class, args);
    }
}

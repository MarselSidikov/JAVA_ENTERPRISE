package ru.itis.storage.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ru.itis.storage")
@EnableJpaRepositories(basePackages = "ru.itis.storage.repositories")
@EntityScan(basePackages = "ru.itis.storage.models")
public class Application  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
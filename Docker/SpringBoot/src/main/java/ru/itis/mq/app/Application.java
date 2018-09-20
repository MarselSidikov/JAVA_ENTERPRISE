package ru.itis.mq.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 16.07.2018
 * ru.itis.mq.app.Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

@SpringBootApplication
public class Application {


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}

package ru.itis.mq.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 16.07.2018
 * Runner
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("spring-boot-exchange", "messages", "Hello from RabbitMQ! " + i);
        }
    }
}

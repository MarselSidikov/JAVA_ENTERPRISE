package ru.itis.mq.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 16.07.2018
 * Receiver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class Receiver {
    @RabbitListener(queues = "spring-boot")
    public void process(String message) {
        System.out.println(message);
    }
}

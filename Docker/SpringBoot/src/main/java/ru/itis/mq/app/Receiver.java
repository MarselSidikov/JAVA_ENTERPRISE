package ru.itis.mq.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 16.07.2018
 * Receiver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class Receiver {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "demo-queue")
    public void process(byte[] messageAsBytes) {
        String jsonMessage = new String(messageAsBytes);
        try {
            Message message = objectMapper.readValue(jsonMessage, Message.class);
            System.out.println(message);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

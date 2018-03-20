package ru.itis.websockets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;

/**
 * 20.03.2018
 * MessageController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/hello")
    public void getMessage(Message<?> message) {
        System.out.println(message);
        template.convertAndSend("/topic/chat/", "hello!");
    }

    @MessageMapping("/bye")
    @SendTo("/topic/chat")
    public TextMessage byeMessage(Message<?> message) {
        return new TextMessage("Bye bye!");
    }
}

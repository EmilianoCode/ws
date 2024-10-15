package com.project.ws;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages") // Donde se enviarán los mensajes
    public Message sendMessage(@Payload Message message) {
        System.out.println(message.getContent());
        message.setTimestamp(new Date());
        return message; // Devuelve el mensaje recibido
    }
}


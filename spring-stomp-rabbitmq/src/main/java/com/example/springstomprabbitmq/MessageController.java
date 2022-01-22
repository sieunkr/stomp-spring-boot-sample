package com.example.springstomprabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations messageSendingOperations;

    /*
    /app/chat/newUser 메시지 발행
    /topic/channelId 구독
     */

    @MessageMapping("/chat/newUser")
    //@SendTo("/topic/test")
    public void newUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());

        messageSendingOperations.convertAndSend("/topic/" + message.getChannelId(), message);
        //return message;
    }
}
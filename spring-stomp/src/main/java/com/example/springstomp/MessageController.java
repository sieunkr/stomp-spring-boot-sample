package com.example.springstomp;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations messageSendingOperations;

    /*
    pub/hello 메시지 발행
    sub/channel/channelId 구독
     */

    @MessageMapping("/hello")
    public void message(Message message) {

        /*
        if, message type 이 init 인 경우..log
         */
        messageSendingOperations.convertAndSend("/sub/channel/" + message.getChannelId(), message);
    }
}
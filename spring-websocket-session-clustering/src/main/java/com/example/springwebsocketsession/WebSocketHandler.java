package com.example.springwebsocketsession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    private static final String TYPE_INIT = "init";
    private static final String TYPE_LOGOUT = "logout";
    
    //웹소켓 연결 시
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        //TODO:
    }

    //양방향 데이터 통신 시
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {

        //TODO:
    }

    //소켓 연결 종료 시
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //TODO:
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        //TODO:
    }

    private void removeUserAndSendLogout(final String sessionId) {

        //TODO:
    }
}
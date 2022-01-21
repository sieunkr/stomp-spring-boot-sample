package com.example.springwebsocket;

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

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    //웹소켓 연결 시
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("[" + session.getId() + "] Connection established ");

        final Message message = new Message();
        message.setType(TYPE_INIT);
        message.setSender(session.getId());

        sessions.put(session.getId(), session);
        sessions.values().forEach(s -> {
            try {
                s.sendMessage(new TextMessage(Utils.getString(message)));
            } catch (Exception e) {
                log.warn("Error while message sending.", e);
            }
        });
    }

    //양방향 데이터 통신 시
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {

        log.info("handleTextMessage : {}", textMessage.getPayload());

        Message message = Utils.getObject(textMessage.getPayload());
        WebSocketSession target = sessions.get(message.getReceiver());

        if (target != null && target.isOpen()) {
            message.setSender(session.getId());
            log.info("send message {} to {}", Utils.getString(message), target);
            target.sendMessage(new TextMessage(Utils.getString(message)));
        }
    }

    //소켓 연결 종료 시
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("[" + session.getId() + "] Connection closed " + session.getId() + " with status: " + status.getReason());
        removeUserAndSendLogout(session.getId());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("[" + session.getId() + "] Connection error " + session.getId() + " with status: " + exception.getLocalizedMessage());
        removeUserAndSendLogout(session.getId());
    }

    private void removeUserAndSendLogout(final String sessionId) {

        sessions.remove(sessionId);

        final Message message = new Message();
        message.setType(TYPE_LOGOUT);
        message.setSender(sessionId);

        sessions.values().forEach(s -> {
            try {
                s.sendMessage(new TextMessage(Utils.getString(message)));
            } catch (Exception e) {
                log.warn("Error while message sending.", e);
            }
        });
    }
}
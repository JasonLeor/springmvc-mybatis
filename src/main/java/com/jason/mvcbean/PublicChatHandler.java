package com.jason.mvcbean;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suliguo on 2017/5/17.
 */
@Component
public class PublicChatHandler implements WebSocketHandler {

    public static Map<String, WebSocketSession> userSocketSessions = new HashMap<String, WebSocketSession>();

    /**
     * 进入房间 建立连接后
     */
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        String uId = (String) webSocketSession.getAttributes().get("uId");
        String roomId = (String) webSocketSession.getAttributes().get("roomId");
        userSocketSessions.put(roomId, webSocketSession);
    }

    /**
     * 发送(收到)消息
     */
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

    }

    /**
     * 异常
     */
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * 退出房间
     */
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {


        System.out.println(11);
    }

    public boolean supportsPartialMessages() {
        return false;
    }
}

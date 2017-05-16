package com.jason.mvcbean;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

/**
 * 处理类
 * Created by suliguo on 2017/5/15.
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {

    /**
     * 建立连接
     */
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

    }

    /**
     * 接收客户端的消息
     */
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println(webSocketMessage.getPayload());
        webSocketSession.sendMessage(new TextMessage("ok"));
    }

    /**
     * 异常
     */
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        webSocketSession.sendMessage(new TextMessage(throwable.getMessage()));
    }

    /**
     * 一个 socket 断开后触发
     */
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

    }

    public boolean supportsPartialMessages() {
        return false;
    }
}

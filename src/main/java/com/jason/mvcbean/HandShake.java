package com.jason.mvcbean;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * tcp 握手拦截器(socket)
 * Created by suliguo on 2017/5/15.
 */
public class HandShake implements HandshakeInterceptor {

    /**
     * 握手前
     */
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
            Map<String, String[]> map = servletServerHttpRequest.getServletRequest().getParameterMap();
            attributes.putAll(map);
        }
        return true;
    }

    /**
     * 握手后
     */
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("after shake");
    }
}


package com.jason.mvcbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by suliguo on 2017/5/15.
 */
@Component
@EnableWebSocket
public class WebMvcConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    @Autowired
    private PublicChatHandler publicChatHandler;

    /**
     * 注册方法 把所有WEBSOCKET的路由要在这注册声明
     */
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(publicChatHandler, "/chatroom").
                setAllowedOrigins("*").addInterceptors(new HandShake());

    }

}

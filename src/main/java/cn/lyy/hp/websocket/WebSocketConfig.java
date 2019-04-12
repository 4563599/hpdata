package cn.lyy.hp.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        System.out.println("registerWebSocketHandlers");
        webSocketHandlerRegistry.addHandler(chatMessageHandler(), "/websocket/webSocketServer.do").addInterceptors(new ChatHandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(chatMessageHandler(), "/sockjs/webSocketServer.do").addInterceptors(new ChatHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public TextWebSocketHandler chatMessageHandler() {
        return new ChatMessageHandler();
    }
}

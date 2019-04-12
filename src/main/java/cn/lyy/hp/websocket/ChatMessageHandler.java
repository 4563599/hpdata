package cn.lyy.hp.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

public class ChatMessageHandler extends TextWebSocketHandler {
    public static final ArrayList<WebSocketSession> users;

    static {
        users = new ArrayList<>();
    }

    public ChatMessageHandler() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 连接成功时候，会触发UI上onOpen方法
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        users.add(session);
        System.out.println("connect to the websocket success......当前数量:" + users.size());
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
    }


    /**
     * 在UI在用js调用websocket.send()时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    /**
     * 给某个用户发送信息
     */

    public void sendMessageToUser(String username, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get(Constants.WEBSOCKET_USERNAME).equals(username))
                if (user.isOpen()) {
                    try {
                        user.sendMessage(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
        }
    }

    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.isOpen()) {
                try {
                    user.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        users.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        users.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}

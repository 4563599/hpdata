package cn.lyy.hp.controller;

import cn.lyy.hp.websocket.ChatMessageHandler;
import cn.lyy.hp.websocket.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class WebsocketController {

    public ChatMessageHandler infoHandler() {
        return new ChatMessageHandler();
    }

    @RequestMapping("/websocket/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        HttpSession session = request.getSession(false);
        session.setAttribute(Constants.SESSION_USERNAME, username);

        response.sendRedirect("/ws.jsp");
    }

    @RequestMapping("/websocket/send")
    @ResponseBody
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
        infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        System.out.println("你好，测试！！！！");
        return null;
    }
}

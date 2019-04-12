package cn.lyy.hp.controller;

import cn.lyy.hp.data.Data;
import cn.lyy.hp.websocket.ChatMessageHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HPDataController {

    private Logger log = Logger.getLogger(HPDataController.class);
    private Data data = Data.getInstance();
    private ChatMessageHandler messageHandler = new ChatMessageHandler();

    @RequestMapping("/info")
    @ResponseBody
    public String getItemCatList(@RequestParam(value = "collect_data", defaultValue = "0") String collect_data) {
        log.error("data :  " + collect_data + "\n");
        data.begin();
        data.count();

        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);

//        String result = "时间-" + dateNowStr + "数据-" + collect_data;
        String result = "时间：    " + dateNowStr + "   数据:" + collect_data;
        messageHandler.sendMessageToUsers(new TextMessage(result));
        return collect_data;
    }


    @RequestMapping("/showDatas")
    public String toWebSocket() {
        return "ws";
    }


    @RequestMapping("/chart")
    public String toChart() {
        return "chart";
    }

}

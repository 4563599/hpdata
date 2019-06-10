package cn.lyy.hp.service;

import cn.lyy.hp.bean.Data;
import cn.lyy.hp.mapper.DataMapper;
import cn.lyy.hp.utils.FileUtils;
import cn.lyy.hp.websocket.ChatMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import sun.rmi.runtime.Log;

import java.util.Timer;

import org.apache.log4j.Logger;

@Service
public class DataService {
    Timer timer;

    @Autowired
    DataMapper dataMapper;
    private ChatMessageHandler messageHandler = new ChatMessageHandler();
    Logger logger = Logger.getLogger(this.getClass());

    public void getInfoByMin() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask(), 0,1000);
        }
    }


    public class TimerTask extends java.util.TimerTask {

        public void run() {
            Data data = dataMapper.getData();
            if (data.getPic_name().endsWith("dat")) {
                String datas = FileUtils.readDat(data.getPic_url());
                messageHandler.sendMessageToUsers(new TextMessage(datas));
                logger.error(datas);
            }
        }
    }

}

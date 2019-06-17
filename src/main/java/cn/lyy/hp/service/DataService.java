package cn.lyy.hp.service;

import cn.lyy.hp.bean.Data;
import cn.lyy.hp.bean.SimpleDatasBean;
import cn.lyy.hp.mapper.DataMapper;
import cn.lyy.hp.utils.FileUtils;
import cn.lyy.hp.websocket.ChatMessageHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;

import org.apache.log4j.Logger;

@Service
public class DataService {
    Timer timer;

    @Autowired
    DataMapper dataMapper;
    private ChatMessageHandler messageHandler = new ChatMessageHandler();
    Logger logger = Logger.getLogger(this.getClass());

    public SimpleDatasBean getInfoByMin() {
        Data data = dataMapper.getData();
        if (data.getPic_name().endsWith("dat")) {
            String datas = FileUtils.readDat(data.getPic_url());
            datas = "{\"data\":" + datas + "}";
            Gson gson = new Gson();
            SimpleDatasBean dataBean = gson.fromJson(datas, SimpleDatasBean.class);
            //messageHandler.sendMessageToUsers(new TextMessage(gson.toJson(dataBean)));
            logger.error(datas);
            return dataBean;
        }
        return null;
    }
}

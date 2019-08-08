package cn.lyy.hp.service;

import cn.lyy.hp.bean.Data;
import cn.lyy.hp.bean.HPData;
import cn.lyy.hp.bean.SimpleDatasBean;
import cn.lyy.hp.filesystem.response.ResponseResult;
import cn.lyy.hp.mapper.DataMapper;
import cn.lyy.hp.utils.FileUtils;
import cn.lyy.hp.websocket.ChatMessageHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public SimpleDatasBean getPictures() {
        return dataMapper.getPictures();
    }

    public void saveHPDatas(HPData hpData, String formatTime) {
//        dataMapper.saveA1_variance(hpData.getA1_variance());
//        dataMapper.saveA2_variance(hpData.getA2_variance());
//        dataMapper.saveA3_variance(hpData.getA3_variance());
//        dataMapper.saveAx_variance(hpData.getAx_variance());
//        dataMapper.saveAy_variance(hpData.getAy_variance());
//        dataMapper.saveAz_variance(hpData.getAz_variance());
//        dataMapper.savePressure1_mean(hpData.getPressure1_mean());
//        dataMapper.saveT1(hpData.getT1());
//        dataMapper.saveT2(hpData.getT2());
//        dataMapper.saveT3(hpData.getT3());
//        dataMapper.saveT4(hpData.getT4());
//        dataMapper.saveT5(hpData.getT5());
//        dataMapper.saveHumidity1_mean(hpData.getHumidity1_mean());
//        dataMapper.saveHumidity2_mean(hpData.getHumidity2_mean());
//        dataMapper.saveHumidity3_mean(hpData.getHumidity3_mean());
//        dataMapper.saveHumidity4_mean(hpData.getHumidity4_mean());
//        dataMapper.saveHumidity5_mean(hpData.getHumidity5_mean());
//        dataMapper.saveV1_mean(hpData.getV1_mean());
//        dataMapper.saveV2_mean(hpData.getV2_mean());
//        dataMapper.saveV3_mean(hpData.getV3_mean());
//        dataMapper.saveV4_mean(hpData.getV4_mean());
//        dataMapper.saveV5_mean(hpData.getV5_mean());
//        dataMapper.saveV6_mean(hpData.getV6_mean());
//        dataMapper.saveV7_mean(hpData.getV7_mean());
//        dataMapper.saveV8_mean(hpData.getV8_mean());
//        dataMapper.saveV9_mean(hpData.getV9_mean());
//        dataMapper.saveV10_mean(hpData.getV10_mean());
//        dataMapper.saveV11_mean(hpData.getV11_mean());
//        dataMapper.saveV12_mean(hpData.getV12_mean());
//        dataMapper.saverainfall_mean(hpData.getRainfall_mean());
//        dataMapper.saveilluminance_mean(hpData.getIlluminance_mean());
//        dataMapper.savedisplacement1_mean(hpData.getDisplacement1_mean());
//        dataMapper.savedisplacement2_mean(hpData.getDisplacement2_mean());
//        dataMapper.saveTime(hpData.getTime());
//        dataMapper.saveFormatTime(formatTime);
        dataMapper.saveDatas(hpData.getA1_variance(),
                hpData.getA2_variance(),
                hpData.getA3_variance(),
                hpData.getAx_variance(),
                hpData.getAy_variance(),
                hpData.getAz_variance(),
                hpData.getPressure1_mean(),
                hpData.getT1(),
                hpData.getT2(),
                hpData.getT3(),
                hpData.getT4(),
                hpData.getT5(),
                hpData.getHumidity1_mean(),
                hpData.getHumidity2_mean(),
                hpData.getHumidity3_mean(),
                hpData.getHumidity4_mean(),
                hpData.getHumidity5_mean(),
                hpData.getV1_mean(),
                hpData.getV2_mean(),
                hpData.getV3_mean(),
                hpData.getV4_mean(),
                hpData.getV5_mean(),
                hpData.getV6_mean(),
                hpData.getV7_mean(),
                hpData.getV8_mean(),
                hpData.getV9_mean(),
                hpData.getV10_mean(),
                hpData.getV11_mean(),
                hpData.getV12_mean(),
                hpData.getV13_mean(),
                hpData.getV14_mean(),
                hpData.getV15_mean(),
                hpData.getV16_mean(),
                hpData.getRainfall_mean(),
                hpData.getIlluminance_mean(),
                hpData.getDisplacement1_mean(),
                hpData.getDisplacement2_mean(),
                hpData.getTime(),
                formatTime);
    }

}

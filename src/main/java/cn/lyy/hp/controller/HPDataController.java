package cn.lyy.hp.controller;

import cn.jiguang.common.resp.BooleanResult;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import cn.lyy.hp.bean.HPData;
import cn.lyy.hp.bean.SimpleDatasBean;
import cn.lyy.hp.data.Data;
import cn.lyy.hp.filesystem.response.CommonCode;
import cn.lyy.hp.filesystem.response.ResponseResult;
import cn.lyy.hp.service.DataService;
import cn.lyy.hp.utils.AjaxResult;
import cn.lyy.hp.utils.JpushUtil;
import cn.lyy.hp.websocket.ChatMessageHandler;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HPDataController {

    @Autowired
    DataService dataService;

    private Logger log = Logger.getLogger(HPDataController.class);
    private Data data = Data.getInstance();
    private ChatMessageHandler messageHandler = new ChatMessageHandler();

    @RequestMapping("/upload_data")
    @ResponseBody
    public ResponseResult getInfo(@RequestParam(value = "datas", defaultValue = "0") String datas) {
        log.debug("data :  " + datas + "\n");
        try {
            Gson gson = new Gson();
            HPData hpData = gson.fromJson(datas, HPData.class);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateNowStr = sdf.format(d);

            dataService.saveHPDatas(hpData, dateNowStr);
            ResponseResult responseResult = new ResponseResult(CommonCode.SUCCESS, datas);
            String result = "时间：    " + dateNowStr + "   数据:" + datas;
            messageHandler.sendMessageToUsers(new TextMessage(result));
            return responseResult;
        } catch (Exception e) {
            ResponseResult responseResult = new ResponseResult(CommonCode.FAIL, e.toString());
            return responseResult;
        }

    }


    //    @RequestMapping("/upload_data_json")
    @PostMapping(value = "/upload_data_json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseResult getJsonInfo(@RequestBody HPData hpData) {
        ResponseResult responseResult = new ResponseResult(CommonCode.SUCCESS, hpData.toString());
        return responseResult;
    }


    @RequestMapping("/info_min")
    @ResponseBody
    public SimpleDatasBean getInfoByMin() {
        //每分钟得到最新数据数据
        return dataService.getInfoByMin();
    }

    @RequestMapping("/getPictures")
    @ResponseBody
    public SimpleDatasBean getPictures() {
        //每分钟得到最新数据数据
        return dataService.getPictures();
    }


    @RequestMapping("/showDatas")
    public String toWebSocket() {
        return "ws";
    }


    @RequestMapping("/chart")
    public String toChart() {
        return "chart";
    }


    @RequestMapping("/jpush/push.do")
    @ResponseBody
    public AjaxResult doAdd(String content) {
        AjaxResult result = new AjaxResult();

        try {
            JPushClient jpushClient = new JPushClient("1a5856e2537f13e737b27eed", "c21203d1078ef607b2d2133d");

            //创建推送对象，举例：根据别名推送通知，具体方法实现在下边的工具类中
            List<String> list = new ArrayList<>();
            list.add("all");
            PushPayload pushPayload = JpushUtil.buildPushObject_all_aliases_alertWithTitle(list, "滑坡提醒", content, null);
            //进行推送
            PushResult pushResult = jpushClient.sendPush(pushPayload);
            result.setData(pushResult);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            System.out.println("推送失败");
        }
        return result;
    }


}

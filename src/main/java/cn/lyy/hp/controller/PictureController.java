package cn.lyy.hp.controller;

import cn.lyy.hp.bean.SimpleDatasBean;
import cn.lyy.hp.fastdfs.FastDFSClient;
import cn.lyy.hp.filesystem.response.CommonCode;
import cn.lyy.hp.filesystem.response.ResponseResult;
import cn.lyy.hp.filesystem.response.ResultCode;
import cn.lyy.hp.filesystem.response.UploadURLResult;
import cn.lyy.hp.service.PictureService;
import cn.lyy.hp.utils.DateUtils;
import cn.lyy.hp.utils.FileUtils;
import cn.lyy.hp.utils.OSSClientUtil;
import cn.lyy.hp.utils.PicUtils;
import cn.lyy.hp.websocket.ChatMessageHandler;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.google.gson.Gson;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.log4j.Logger;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Controller
public class PictureController {

    private String IMAGE_SERVER_URL = "http://120.77.144.115:8888/";
    @Autowired
    PictureService pictureService;

    private Logger logger = Logger.getLogger(getClass());
    private OSSClientUtil ossClientUtil;

    private ChatMessageHandler messageHandler = new ChatMessageHandler();


    public static String ENDPOINT = "http://oss-cn-shenzhen.aliyuncs.com";
    public static String ACCESSKEYID = "LTAIYHofvJPpFKPR";
    public static String ACCESSKEYSECRET = "Ih7zp0m2mKSSR89dmEzdr4POYTvYUs";
    public static String BUCKETNAME = "hpdata";
    public static String KEY = "images/";

    @RequestMapping("/upload")
    @ResponseBody
    public UploadURLResult fileUpload(MultipartFile uploadFile) {
        try {
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String time = DateUtils.getCurrentDateTime();
            if (ossClientUtil == null) {
                ossClientUtil = new OSSClientUtil();
            }
            ossClientUtil.init();
            String name = ossClientUtil.uploadImg2Oss(uploadFile);
            String imgUrl = ossClientUtil.getImgUrl(name);
            if (originalFilename.contains(".png")) {
                pictureService.addPicture(originalFilename, imgUrl, time);
            } else {
                //存入数据库
                pictureService.addData(originalFilename, imgUrl, time);
            }

            ossClientUtil.destory();
            String json = FileUtils.readOSSDat(KEY + name);
            json = "{\"data\":" + json + "}";
            Gson gson = new Gson();
            SimpleDatasBean dataBean = gson.fromJson(json, SimpleDatasBean.class);
            String get_time = dataBean.getData().get(dataBean.getData().size() - 1).getTime();
            String t1 = dataBean.getData().get(dataBean.getData().size() - 1).getT1();
            String humidity1 = dataBean.getData().get(dataBean.getData().size() - 1).getHumidity1();
            String pressure1 = dataBean.getData().get(dataBean.getData().size() - 1).getPressure1();
            String rainfall = dataBean.getData().get(dataBean.getData().size() - 1).getRainfall();
            String a1 = dataBean.getData().get(dataBean.getData().size() - 1).getA1();
            String stressy = dataBean.getData().get(dataBean.getData().size() - 1).getStressy();
            pictureService.insertT1(get_time, t1);
            pictureService.insertHumidity1(get_time, humidity1, pressure1, rainfall, a1, stressy);
            pictureService.insertPressure1(get_time, humidity1, pressure1, rainfall, a1, stressy);
            pictureService.insertRainfall(get_time, humidity1, pressure1, rainfall, a1, stressy);
            pictureService.insertA1(get_time, humidity1, pressure1, rainfall, a1, stressy);
            pictureService.insertStressy(get_time, humidity1, pressure1, rainfall, a1, stressy);

            logger.error(json);
            return new UploadURLResult(CommonCode.SUCCESS, originalFilename, imgUrl, time);
        } catch (Exception e) {
            ossClientUtil.destory();
            e.printStackTrace();
            return new UploadURLResult(CommonCode.FAIL, "");
        }

    }


    @ResponseBody
    @RequestMapping(value = "/upload_pic")
    public UploadURLResult myphotoupload(MultipartFile uploadFile) {

//        JSONObject ret = new JSONObject();
//        String key = "";
//        String fileNames = "";
//        ret.put("success", false);
//        ret.put("msg", "请求失败[PU01]");
//        try {
//            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
//            Iterator<String> iterator = req.getFileNames();
//            while (iterator.hasNext()) {
//                MultipartFile file = req.getFile(iterator.next());
//                fileNames = file.getOriginalFilename();
//                InputStream input = file.getInputStream();
//
//                // 创建OSSClient实例
//                OSSClient ossClient = new OSSClient(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);
//                // 上传文件流
//                ossClient.putObject(BUCKETNAME, KEY + fileNames, input);
//                ossClient.shutdown();
//            }
//            ret.put("success", true);
//            ret.put("msg", key + fileNames);
//            System.out.println(("图片上传阿里云 name=" + key + fileNames));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            String time = DateUtils.getCurrentDateTime();
            String name = ossClientUtil.uploadImg2Oss(uploadFile);
            String imgUrl = ossClientUtil.getImgUrl(name);
            return new UploadURLResult(CommonCode.SUCCESS, name, imgUrl, time);
        } catch (Exception e) {
            return new UploadURLResult(CommonCode.FAIL, "");
        }
    }


    @RequestMapping("/convertPictures")
    @ResponseBody
    public String convertPictures() {
        int[][] picsArray = PicUtils.img2color("C:\\Users\\A18072\\Desktop\\DVI\\20190412_110753.png");
//        Gson gson = new Gson();
//        String result = gson.toJson(picsArray);
        return Arrays.deepToString(picsArray);
    }


}

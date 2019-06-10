package cn.lyy.hp.controller;

import cn.lyy.hp.fastdfs.FastDFSClient;
import cn.lyy.hp.filesystem.response.CommonCode;
import cn.lyy.hp.filesystem.response.ResponseResult;
import cn.lyy.hp.filesystem.response.ResultCode;
import cn.lyy.hp.filesystem.response.UploadURLResult;
import cn.lyy.hp.service.PictureService;
import cn.lyy.hp.utils.DateUtils;
import cn.lyy.hp.utils.PicUtils;
import cn.lyy.hp.websocket.ChatMessageHandler;
import com.google.gson.Gson;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.TextMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Controller
public class PictureController {

    private String IMAGE_SERVER_URL = "http://120.77.144.115:8888/";
    @Autowired
    PictureService pictureService;

    @Autowired
    DatContorller datContorller;

    private ChatMessageHandler messageHandler = new ChatMessageHandler();

    @RequestMapping("/upload")
    @ResponseBody
    public UploadURLResult fileUpload(MultipartFile uploadFile) {
        try {
            // 1、取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 2、创建一个FastDFS的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/resource.properties");
            // 3、执行上传处理
            String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            // 4、拼接返回的url和ip地址，拼装成完整的url
            String url = IMAGE_SERVER_URL + path;
            //存入数据库
            String time = DateUtils.getCurrentDateTime();
            pictureService.addPicture(originalFilename, url, time);

            datContorller.readDat(originalFilename, url, time);
            if (extName.endsWith("dat")) {
                String data = readDat(url);
                messageHandler.sendMessageToUsers(new TextMessage(data));
            }
            return new UploadURLResult(CommonCode.SUCCESS, originalFilename, url, time);

        } catch (Exception e) {
            e.printStackTrace();
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


    //    public String readDat(String data_url) {
//        try {
//            URL url = new URL(data_url);
//            // 打开连接
//            URLConnection con = url.openConnection();
//            //设置请求超时为5s
//            con.setConnectTimeout(5 * 1000);
//            // 输入流
//            InputStream inputStream = con.getInputStream();
//            int length = inputStream.available();
//            byte bytes[] = new byte[length];
//            inputStream.read(bytes);
//            inputStream.close();
//            String str = new String(bytes, StandardCharsets.UTF_8);
//            return str;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//
//
//
//    }
    public String readDat(String data_url) {
        try {
            URL url = new URL(data_url);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            //得到输入流
            InputStream inputStream = con.getInputStream();

            byte[] getData = readInputStream(inputStream);
            inputStream.read(getData);
            String str = new String(getData);
            System.out.println("打印内容：" + str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}

package cn.lyy.hp.controller;

import cn.lyy.hp.fastdfs.FastDFSClient;
import cn.lyy.hp.filesystem.response.CommonCode;
import cn.lyy.hp.filesystem.response.ResponseResult;
import cn.lyy.hp.filesystem.response.ResultCode;
import cn.lyy.hp.filesystem.response.UploadURLResult;
import cn.lyy.hp.service.PictureService;
import cn.lyy.hp.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@Controller
public class PictureController {

    private String IMAGE_SERVER_URL = "http://120.77.144.115:8888/";
    @Autowired
    PictureService pictureService;

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
            return new UploadURLResult(CommonCode.SUCCESS, originalFilename, url, time);
        } catch (Exception e) {
            e.printStackTrace();
//            // 5、返回map
//            Map result = new HashMap<>();
//            result.put("error", 1);
//            result.put("message", "图片上传失败");
            return new UploadURLResult(CommonCode.FAIL, "");
        }

    }
}

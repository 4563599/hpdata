package cn.lyy.hp.controller;

import cn.lyy.hp.fastdfs.FileSystemService;
import cn.lyy.hp.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/filesystem")
public class FastDFSController {
//    @Autowired
//    FileSystemService fileSystemService;
//
//
//    @PostMapping("/upload")
//    public UploadFileResult upload(MultipartFile multipartFile, String filetag, String businesskey, String metadata) {
//        return fileSystemService.upload(multipartFile, filetag, businesskey, metadata);
//    }
}

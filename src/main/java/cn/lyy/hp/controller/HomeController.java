package cn.lyy.hp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/index")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }


    @GetMapping(value = "/data")
    public String data() {
        return "data";
    }


    @GetMapping(value = "/upload_test")
    public String upload_test() {
        return "upload_test";
    }

    @GetMapping(value = "/upload_test_oss")
    public String upload_test_oss() {
        return "upload_test_oss";
    }

    @GetMapping(value = "/current_page")
    public String current_page() {
        return "current_page";
    }


}

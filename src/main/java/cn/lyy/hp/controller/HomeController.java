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

    @GetMapping(value = "/Humidity1_page")
    public String Humidity1_page() {
        return "Humidity1_page";
    }


    @GetMapping(value = "/Pressure1_page")
    public String Pressure1_page() {
        return "Pressure1_page";
    }

    @GetMapping(value = "/A1_page")
    public String A1_page() {
        return "A1_page";
    }


    @GetMapping(value = "/rainfall_page")
    public String rainfall_page() {
        return "rainfall_page";
    }

    @GetMapping(value = "/illuminance_page")
    public String illuminance_page() {
        return "illuminance_page";
    }


    @GetMapping(value = "/V1_page")
    public String V1_page() {
        return "V1_page";
    }

    @GetMapping(value = "/displacement1_page")
    public String displacement1_page() {
        return "displacement1_page";
    }

}

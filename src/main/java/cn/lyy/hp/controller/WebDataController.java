package cn.lyy.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebDataController {
    @GetMapping(value = "/t_page")
    public String t_page() {
        return "t_page";
    }

    @GetMapping(value = "/push_page")
    public String push_page() {
        return "push_page";
    }
}

package cn.lyy.hp.controller;

import cn.lyy.hp.bean.User;
import cn.lyy.hp.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(String name) {
        String password = null;
        if (StringUtils.isNotBlank(name)) {
            password = userService.getUser(name);
        }
        return password;
    }

//    @RequestMapping("getAllUser")
//    @ResponseBody
//    public List<User> getUser() {
//        return userService.getList();
//    }
}

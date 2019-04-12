package cn.lyy.hp.service;

import cn.lyy.hp.bean.User;
import cn.lyy.hp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String getUser(String name) {
        return userMapper.getUser(name);
    }


//    public List<User> getList() {
//        return userMapper.listAll();
//    }
}

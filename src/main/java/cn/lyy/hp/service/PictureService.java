package cn.lyy.hp.service;

import cn.lyy.hp.mapper.PictureMapper;
import cn.lyy.hp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    public void addPicture(String pic_name, String pic_url, String update_time) {
        pictureMapper.insertPicture(pic_name, pic_url, update_time);
    }

    public void addData(String pic_name, String pic_url, String update_time) {
        pictureMapper.insertData(pic_name, pic_url, update_time);
    }
}

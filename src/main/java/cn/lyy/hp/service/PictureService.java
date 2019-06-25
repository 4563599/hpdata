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


    public void insertT1(String get_time, String t1) {
        pictureMapper.insertT1(get_time, t1);
    }

    public void insertHumidity1(String get_time, String humidity1, String pressure1, String rainfall, String a1, String stressy) {
        pictureMapper.insertHumidity1(get_time, humidity1);
    }

    public void insertPressure1(String get_time, String humidity1, String pressure1, String rainfall, String a1, String stressy) {
        pictureMapper.insertPressure1(get_time, pressure1);
    }

    public void insertRainfall(String get_time, String humidity1, String pressure1, String rainfall, String a1, String stressy) {
        pictureMapper.insertRainfall(get_time, rainfall);
    }

    public void insertA1(String get_time, String humidity1, String pressure1, String rainfall, String a1, String stressy) {
        pictureMapper.insertA1(get_time, a1);
    }

    public void insertStressy(String get_time, String humidity1, String pressure1, String rainfall, String a1, String stressy) {
        pictureMapper.insertStressy(get_time, stressy);
    }


}

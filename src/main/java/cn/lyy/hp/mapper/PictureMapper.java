package cn.lyy.hp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PictureMapper {
    void insertPicture(@Param("pic_name") String pic_name, @Param("pic_url") String pic_url, @Param("update_time") String update_time);

    void insertData(@Param("pic_name") String pic_name, @Param("pic_url") String pic_url, @Param("update_time") String update_time);

    void insertT1(@Param("get_time") String get_time, @Param("t1") String t1);

    void insertHumidity1(@Param("get_time") String get_time, @Param("humidity1") String humidity1);

    void insertPressure1(@Param("get_time") String get_time, @Param("pressure1") String pressure1);

    void insertRainfall(@Param("get_time") String get_time, @Param("rainfall") String rainfall);

    void insertA1(@Param("get_time") String get_time, @Param("a1") String a1);

    void insertStressy(@Param("get_time") String get_time, @Param("stressy") String stressy);
}

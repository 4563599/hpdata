package cn.lyy.hp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PictureMapper {
    void insertPicture(@Param("pic_name") String pic_name, @Param("pic_url") String pic_url, @Param("update_time") String update_time);

    void insertData(@Param("pic_name") String pic_name, @Param("pic_url") String pic_url, @Param("update_time") String update_time);
}

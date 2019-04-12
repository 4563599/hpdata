package cn.lyy.hp.mapper;

import cn.lyy.hp.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    String getUser(@Param("name") String name);

    List<User> listAll();
}

package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    long insert(User user);

    boolean selectUsernameUnique(String username);

    User selectByUsername(String username);

    void update(User user);
}
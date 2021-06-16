package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoMapper {
    long insert(UserInfo userInfo);

    UserInfo selectByUserId(long userId);

    void update(UserInfo userInfo);
}
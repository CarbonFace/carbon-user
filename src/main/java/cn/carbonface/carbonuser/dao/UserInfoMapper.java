package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    long insert(UserInfo userInfo);
}
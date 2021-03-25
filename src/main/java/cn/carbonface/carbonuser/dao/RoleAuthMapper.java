package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.RoleAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleAuthMapper {
    List<RoleAuth> selectByUserId(Long userId);
}
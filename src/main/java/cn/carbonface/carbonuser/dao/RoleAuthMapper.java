package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.RoleAuth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleAuthMapper {
    List<RoleAuth> selectByUserId(Long userId);
}
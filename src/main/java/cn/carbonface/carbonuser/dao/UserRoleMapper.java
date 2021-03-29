package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserRoleMapper {

    List<UserRole> selectByUserId(Long userId);

    UserRole selectByName(String roleName);

    void insertUserRoleLink(Long userId, Long roleId);
}
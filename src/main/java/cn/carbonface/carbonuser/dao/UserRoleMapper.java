package cn.carbonface.carbonuser.dao;

import cn.carbonface.carbonuser.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<UserRole> selectByUserId(Long userId);

    UserRole selectByName(String roleName);

    void insertUserRoleLink(Long userId, Long roleId);
}
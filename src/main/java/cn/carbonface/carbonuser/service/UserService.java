package cn.carbonface.carbonuser.service;


import cn.carbonface.carboncommon.exception.CarbonException;
import cn.carbonface.carbonuser.dto.UserDto;
import cn.carbonface.carbonuser.entity.RoleAuth;
import cn.carbonface.carbonuser.entity.User;
import cn.carbonface.carbonuser.entity.UserRole;
import cn.carbonface.carboncommon.exception.ApiException;

import java.util.List;

public interface UserService {

    List<UserRole> getRoleByUserId(Long userId);

    void addUser(UserDto userDto) throws CarbonException;

    User getUserByUsername(String username);

    void resetUserPassword(User user) throws CarbonException;

    UserRole getRoleByName(String roleName);

    List<RoleAuth> getAuthByUserId(Long id);
}

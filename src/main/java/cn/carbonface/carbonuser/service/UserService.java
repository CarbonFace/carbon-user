package cn.carbonface.carbonuser.service;


import cn.carbonface.carboncommon.exception.CarbonException;
import cn.carbonface.carbonuser.dto.UserDto;
import cn.carbonface.carbonuser.entity.RoleAuth;
import cn.carbonface.carbonuser.entity.User;
import cn.carbonface.carbonuser.entity.UserImage;
import cn.carbonface.carbonuser.entity.UserRole;
import cn.carbonface.carbonuser.vo.UserVo;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserService {

    UserImage getUserImage(@NotNull String username);

    List<UserRole> getRoleByUserId(Long userId);

    void addUser(UserDto userDto) throws CarbonException;

    User getUserByUsername(String username);

    void resetUserPassword(User user) throws CarbonException;

    UserRole getRoleByName(String roleName);

    List<RoleAuth> getAuthByUserId(Long id);

    UserVo getUserInfo();

    void updateUserInfo(UserVo userVo) throws CarbonException;
}

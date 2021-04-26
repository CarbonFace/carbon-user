package cn.carbonface.carbonuser.service.impl;


import cn.carbonface.carboncommon.dto.RetCode;
import cn.carbonface.carboncommon.exception.CarbonException;
import cn.carbonface.carbonuser.dao.RoleAuthMapper;
import cn.carbonface.carbonuser.dao.UserInfoMapper;
import cn.carbonface.carbonuser.dao.UserMapper;
import cn.carbonface.carbonuser.dao.UserRoleMapper;
import cn.carbonface.carbonuser.dto.UserDto;
import cn.carbonface.carbonuser.entity.RoleAuth;
import cn.carbonface.carbonuser.entity.User;
import cn.carbonface.carbonuser.entity.UserInfo;
import cn.carbonface.carbonuser.entity.UserRole;
import cn.carbonface.carbonuser.service.UserService;
import cn.carbonface.carboncommon.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description UserServiceImpl for the UserService
 * @Author CarbonFace <553127022@qq.com>
 * @Date 2021/3/15 17:15
 * @Version V1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final String ROLE_ADMIN  = "ADMIN";
    private static final String ROLE_USER   = "USER";


    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;
    private final UserInfoMapper userInfoMapper;
    private final RoleAuthMapper roleAuthMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserMapper userMapper, UserRoleMapper userRoleMapper, UserInfoMapper userInfoMapper, RoleAuthMapper roleAuthMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
        this.userInfoMapper = userInfoMapper;
        this.roleAuthMapper = roleAuthMapper;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * @description: method use for get user model by username
     * @param username
     * @return com.carbonface.entity.User
     * @author: CarbonFace <553127022@qq.com>
     * @date: 2021/3/16 14:05
     * @version: 1.0
     */
    @Override
    public User getUserByUsername(String username){
        User user = userMapper.selectByUsername(username);
        return user;
    }


    /**
     * @description: getRoleByUserId
     * @param userId
     * @return java.util.List<com.carbonface.entity.UserRole>
     * @author: CarbonFace  <553127022@qq.com>
     * @date: 2021/3/18 10:43
     * @version: 1.0
     */
    @Override
    public List<UserRole> getRoleByUserId(Long userId) {
        List<UserRole> userRoles = userRoleMapper.selectByUserId(userId);
        return userRoles;
    }

    /**
     *
     * @Description get role by rolename
     * @param roleName
     * @return cn.carbonface.carbonuser.entity.UserRole
     * @author CarbonFace <553127022@qq.com>
     * @date 2021/4/9 18:03
     * @version 1.0
     */
    @Override
    public UserRole getRoleByName(String roleName){
        UserRole userRole = userRoleMapper.selectByName(roleName);
        return userRole;
    }

    /**
     * @description: getAuthByUserId
     *
     * @param userId
     * @return java.util.List<com.carbonface.entity.RoleAuth>
     * @author: CarbonFace  <553127022@qq.com>
     * @date: 2021/3/18 18:13
     * @version: 1.0
     */
    @Override
    public List<RoleAuth> getAuthByUserId(Long userId) {
        List<RoleAuth> roleAuths = roleAuthMapper.selectByUserId(userId);
        return roleAuths;
    }

    @Transactional
    @Override
    /**
     *
     * @Description add user service for add new user for the carbon-user
     * @param userDto
     * @return void
     * @author CarbonFace <553127022@qq.com>
     * @date 2021/4/9 18:02
     * @version 1.0
     */
    public void addUser(UserDto userDto) throws ApiException {
        User user = userDto.getUser();
        UserInfo userInfo = userDto.getUserInfo();
        boolean usernameUnique = userMapper.selectUsernameUnique(user.getUsername());
        if (!usernameUnique){
            throw new ApiException(RetCode.USER_ACCOUNT_ALREADY_EXIST);
        }
        String password = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodePassword);
        long insert = userMapper.insert(user);
        userInfo.setUserId(user.getId());
        UserRole userRole = getRoleByName(ROLE_USER);
        userRoleMapper.insertUserRoleLink(user.getId(),userRole.getId());
        userInfoMapper.insert(userInfo);
    }


    /**
     * @description: reset user's password, as well as generate new password salt along with update DB
     *
     * @param user
     * @return void
     * @author: CarbonFace <553127022@qq.com>
     * @date: 2021/3/16 14:06
     * @version: 1.0
     */
    @Transactional
    @Override
    public void resetUserPassword(User user) throws CarbonException {
        String username = user.getUsername();
        //get old DO from database by account
        User dbUser = getUserByUsername(username);
        String newPassword = user.getPassword();
        String encodeNewPassword = bCryptPasswordEncoder.encode(newPassword);
        dbUser.setPassword(encodeNewPassword);
        //update database
        userMapper.update(dbUser);
    }


}

package cn.carbonface.carbonuser.controller;

import cn.carbonface.carboncommon.dto.ApiResult;
import cn.carbonface.carboncommon.exception.ApiException;
import cn.carbonface.carboncommon.validate.groups.Add;
import cn.carbonface.carbonsecurity.core.interceptor.FeignOnly;
import cn.carbonface.carbonsecurity.core.interceptor.NoAuth;
import cn.carbonface.carbonuser.dto.UserDto;
import cn.carbonface.carbonuser.entity.RoleAuth;
import cn.carbonface.carbonuser.entity.User;
import cn.carbonface.carbonuser.entity.UserRole;
import cn.carbonface.carbonuser.service.UserService;
import cn.carbonface.carbonuser.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description UserController for the user service
 * @Author CarbonFace <553127022@qq.com>
 * @Date 2021/3/15 15:15
 * @Version V1.0
 */
@RestController
@RequestMapping("user")
@Slf4j
@Api(value = "用户接口")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    @ApiOperation("添加用户")
    @NoAuth
    public ApiResult addUser(@Validated({Add.class}) UserVo userVo) throws ApiException {
        UserDto userDto = new UserDto(userVo);
        userService.addUser(userDto);
        return ApiResult.ok("用户创建成功！");
    }

    @GetMapping("hello")
    @ApiOperation("hello 方法")
    public String hello() {
        return "hello!!";
    }

    @PostMapping("getRoleByUserId")
    @FeignOnly
    public List<UserRole> getRoleByUserId(Long userId) {
        List<UserRole> userRoles = userService.getRoleByUserId(userId);
        return userRoles;
    }

    @PostMapping("getAuthByUserId")
    @FeignOnly
    public List<RoleAuth> getAuthByUserId(Long userId) {
        List<RoleAuth> RoleAuths = userService.getAuthByUserId(userId);
        return RoleAuths;
    }

    @PostMapping("getUserByUsername")
    @FeignOnly
    public User getUserByUsername(String username){
        User user = userService.getUserByUsername(username);
        return user;
    }
}

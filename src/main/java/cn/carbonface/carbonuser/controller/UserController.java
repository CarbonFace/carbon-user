package cn.carbonface.carbonuser.controller;

import cn.carbonface.carboncommon.dto.ApiResult;
import cn.carbonface.carboncommon.exception.CarbonException;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classname: UserController
 * Description: UserController for the user service
 * @author CarbonFace <553127022@qq.com>
 * Date: 2021/3/15 15:15
 * @version V1.0
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
    public ApiResult<?> addUser( @Validated({Add.class}) @RequestBody UserVo userVo) throws CarbonException {
        UserDto userDto = new UserDto(userVo);
        userService.addUser(userDto);
        return ApiResult.okMsg("用户创建成功！");
    }

    @GetMapping("info")
    @ApiOperation("用户信息")
    public ApiResult<UserVo> userInfo(){
        UserVo userInfo = userService.getUserInfo();
        return ApiResult.ok(userInfo);
    }

    @PostMapping("update")
    @ApiOperation("更新用户信息")
    public ApiResult<?> userInfoUpdate(@RequestBody UserVo userVo) throws CarbonException {
        userService.updateUserInfo(userVo);
        return ApiResult.ok("用户信息更新成功");
    }
    @GetMapping("hello")
    @ApiOperation("hello 方法")
    public String hello() {
        return "hello!!";
    }

    @PostMapping("getRoleByUserId")
    @FeignOnly
    public ApiResult<List<UserRole>> getRoleByUserId(Long userId) {
        List<UserRole> userRoles = userService.getRoleByUserId(userId);
        return ApiResult.ok(userRoles);
    }

    @PostMapping("getAuthByUserId")
    @FeignOnly
    public ApiResult<List<RoleAuth>> getAuthByUserId(Long userId) {
        List<RoleAuth> roleAuths = userService.getAuthByUserId(userId);
        return ApiResult.ok(roleAuths);
    }

    @PostMapping("getUserByUsername")
    @FeignOnly
    public ApiResult<User> getUserByUsername(String username){
        User user = userService.getUserByUsername(username);
        return ApiResult.ok(user);
    }
}

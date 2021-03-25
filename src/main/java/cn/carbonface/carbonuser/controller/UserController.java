package cn.carbonface.carbonuser.controller;

import cn.carbonface.carbonuser.dto.UserDto;
import cn.carbonface.carbonuser.service.UserService;
import cn.carbonface.carbonuser.vo.UserVo;
import cn.carbonface.common.dto.ApiResult;
import cn.carbonface.common.exception.ApiException;
import cn.carbonface.common.validate.groups.Add;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "用户接口")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiOperation("添加用户")
    public ApiResult addUser(@Validated({Add.class}) UserVo userVo){
        UserDto userDto = new UserDto(userVo);
        try {
            userService.addUser(userDto);
            return ApiResult.ok("用户创建成功！");
        } catch (ApiException e){
            e.printStackTrace();
            String msg = e.getMessage();
            log.error(msg);
            return ApiResult.error(msg);
        }
    }

    @GetMapping("/hello")
    @ApiOperation("hello 方法")
    public String hello(){
        log.debug("debug");
        log.info("hello!!!");
        return "hello!!";
    }



}

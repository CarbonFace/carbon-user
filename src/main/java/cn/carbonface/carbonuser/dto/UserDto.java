package cn.carbonface.carbonuser.dto;


import cn.carbonface.carbonuser.entity.User;
import cn.carbonface.carbonuser.entity.UserInfo;
import cn.carbonface.carbonuser.vo.UserVo;
import org.springframework.lang.Nullable;


/**
 * Classname: UserDto
 * Description: user data transfer model which contains the user entity and user info
 * @author CarbonFace <553127022@qq.com>
 * Date: 2021/3/15 17:15
 * @version V1.0
 */
public class UserDto {
    private User user;
    private UserInfo userInfo;

    public UserDto() {
    }

    public UserDto(User user, UserInfo userInfo) {
        this.user = user;
        this.userInfo = userInfo;
    }

    public UserDto(UserVo userVo) {
        user = new User();
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        userInfo = new UserInfo();
        userInfo.setName(userVo.getName());
        userInfo.setRealName(userVo.getRealName());
        userInfo.setSex(userVo.getSex());
        userInfo.setPhoneNumber(userVo.getPhoneNumber());
        userInfo.setBirthday(userVo.getBirthday());
        userInfo.setMail(userVo.getMail());
    }

    /**
     *
     * Description: hide user id in some required cases
     * @param
     * @return cn.carbonface.carbonuser.dto.UserDto
     * @author CarbonFace <553127022@qq.com>
     * Date: 2021/4/9 18:05
     * @version 1.0
     */
    public UserDto hideId(){
        if (user != null){
            user.setId(null);
        }
        if (userInfo !=null){
            userInfo.setId(null);
            userInfo.setUserId(null);
        }
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}

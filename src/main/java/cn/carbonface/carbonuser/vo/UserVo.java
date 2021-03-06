package cn.carbonface.carbonuser.vo;



import cn.carbonface.carboncommon.validate.annotations.EnumValue;
import cn.carbonface.carboncommon.validate.groups.Add;
import cn.carbonface.carboncommon.validate.groups.Valid;
import cn.carbonface.carbonuser.entity.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@ApiModel(value = "用户模型",description = "用户模型")
/**
 * Classname: UserVo
 * Description: view model of the user information with validation invoked
 * @author CarbonFace <553127022@qq.com>
 * Date: 2021/3/13 14:15
 * @version V1.0
 */
public class UserVo {

    @ApiModelProperty(value = "账号",notes = "不可重复")
    @NotEmpty(groups = {Add.class, Valid.class},message = "用户名不可为空")
    private String username;
    @ApiModelProperty(value = "密码" )
    @NotEmpty(groups = {Add.class, Valid.class},message = "密码不可为空")
    private String password;
    @ApiModelProperty(value = "用户昵称")
    private String name;
    @ApiModelProperty(value = "用户姓名")
    private String realName;
    @ApiModelProperty(value ="性别",allowableValues=",男,女")
    @EnumValue(message = "性别输入错误",in = {"","男","女"})
    private String sex;
    @ApiModelProperty(value = "用户生日",dataType = "Date")
    private Date birthday;
    @ApiModelProperty(value = "手机号")
    @Pattern(groups = {Add.class},regexp = "^1[0-9]{10}$", message = "手机号格式错误")
    private String phoneNumber;
    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱格式错误")
    private String mail;
    @ApiModelProperty(value = "头像id")
    private String userImageId;

    public UserVo() {
    }

    public UserVo(UserInfo userInfo) {
        this.name = userInfo.getName();
        this.realName = userInfo.getRealName();
        this.birthday = userInfo.getBirthday();
        this.phoneNumber = userInfo.getPhoneNumber();
        this.mail =  userInfo.getMail();
        this.sex = userInfo.getSex();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserImageId() {
        return userImageId;
    }

    public void setUserImageId(String userImageId) {
        this.userImageId = userImageId;
    }
}

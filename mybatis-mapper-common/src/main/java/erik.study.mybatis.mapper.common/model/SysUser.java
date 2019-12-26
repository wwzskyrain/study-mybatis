package erik.study.mybatis.mapper.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable {


    private static final long serialVersionUID = 2594858786930976656L;

    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private String headImg;
    private Date createTime;
//  在测试1对1是，需要一个role属性；在测试1对多时，需要一个roles属性；
//  因为懒，不想写两个User的model，所以关于role的就出现了两个属性
    private SysRole role;

//  注意在写resultMap是，roles的类型需要用ofType来指定，而不是javaType;
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

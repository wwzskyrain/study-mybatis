package erik.study.mybatis.integration.spring.entity;

import java.util.Date;

/**
 * @author erik.wang
 * @date 2020-02-26 20:38
 * @description
 */
public class SysUser {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String info;
    private String headImg;
    private Date createTime;


    public SysUser(Long id, String name, String password, String email, String info, String headImg, Date createTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.info = info;
        this.headImg = headImg;
        this.createTime = createTime;
    }

    public SysUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

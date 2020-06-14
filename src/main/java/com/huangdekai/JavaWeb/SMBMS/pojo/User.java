package com.huangdekai.JavaWeb.SMBMS.pojo;

import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Date;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/6 23:58
 * @Version: 1.0
 * @since: jdk11
 */
public class User {
    private Integer id;         // 用户ID
    private String userCode;    // 用户编码
    private String userName;    // 用户名称
    private String userPassword;// 用户密码
    private Integer gender;     // 性别
    private Date birthday;      // 出生日期
    private String phone;       // 电话
    private String address;     // 地址
    private Integer userRole;   // 用户角色
    private Integer createdBy;   // 创建者ID
    private Date creationDate;  // 创建日期
    private Integer modifyBy;   // 修改者ID
    private Date modifyDate;    // 修改时间

    private Integer age;        // 年龄
    private String userRoleName;// 用户角色名称

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public Integer getAge() {
        Calendar bornYear = Calendar.getInstance();
        bornYear.setTime(this.getBirthday());
        int toyear = Calendar.getInstance().get(Calendar.YEAR);
        return toyear - bornYear.get(Calendar.YEAR);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

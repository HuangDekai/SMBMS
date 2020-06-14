package com.huangdekai.JavaWeb.SMBMS.service.user;

import com.huangdekai.JavaWeb.SMBMS.pojo.User;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/9 0:51
 * @Version: 1.0
 * @since: jdk11
 */
public interface UserService {
    // 用户登陆
    public User login(String userCode, String password);

    // 根据用户id，修改密码
    public boolean updatePassword(int id, String userPassword);
}

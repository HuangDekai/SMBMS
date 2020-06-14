package com.huangdekai.JavaWeb.SMBMS.dao.user;

import com.huangdekai.JavaWeb.SMBMS.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/8 22:29
 * @Version: 1.0
 * @since: jdk11
 */
public interface UserDao {
    // 得到要登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;

    // 修改密码
    public int updatePassword(Connection connection, int id, String userPassword) throws SQLException;
}

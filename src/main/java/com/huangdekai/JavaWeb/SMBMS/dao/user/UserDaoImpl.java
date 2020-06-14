package com.huangdekai.JavaWeb.SMBMS.dao.user;

import com.huangdekai.JavaWeb.SMBMS.dao.BaseDao;
import com.huangdekai.JavaWeb.SMBMS.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/8 22:31
 * @Version: 1.0
 * @since: jdk11
 */
public class UserDaoImpl implements UserDao{
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
                resultSet  = BaseDao.executeQuery(connection, preparedStatement, resultSet, sql, params);

                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getInt("createdBy"));
                    user.setCreationDate(resultSet.getDate("creationDate"));
                    user.setModifyBy(resultSet.getInt("modifyBy"));
                    user.setModifyDate(resultSet.getDate("modifyDate"));
                }
                BaseDao.closeResource(null,preparedStatement,resultSet);

        }
        return user;
    }

    @Override
    public int updatePassword(Connection connection, int id, String userPassword) throws SQLException {
        PreparedStatement preparedStatement = null;
        int execute = 0;

        if (connection != null){
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] paramters = {userPassword,id};

            execute = BaseDao.executeUpdate(connection,preparedStatement,sql,paramters);
            BaseDao.closeResource(null,preparedStatement,null);
        }

        return execute;
    }
}

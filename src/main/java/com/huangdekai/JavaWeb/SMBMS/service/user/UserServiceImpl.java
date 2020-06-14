package com.huangdekai.JavaWeb.SMBMS.service.user;

import com.huangdekai.JavaWeb.SMBMS.dao.BaseDao;
import com.huangdekai.JavaWeb.SMBMS.dao.user.UserDao;
import com.huangdekai.JavaWeb.SMBMS.dao.user.UserDaoImpl;
import com.huangdekai.JavaWeb.SMBMS.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/9 0:57
 * @Version: 1.0
 * @since: jdk11
 */
public class UserServiceImpl implements UserService {

    // 业务层都会调用dao层，所以要引入Dao层
    private UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    @Override
    public User login(String userCode, String password){
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            // 通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection,userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }

        return user;
    }

    @Override
    public boolean updatePassword(int id, String userPassword) {
        Connection connection = null;
        boolean flag = false;

        try {
            connection  = BaseDao.getConnection();
            int execute = userDao.updatePassword(connection,id,userPassword);
            if (execute > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }

        return flag;
    }
}

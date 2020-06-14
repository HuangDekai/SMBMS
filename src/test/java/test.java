import com.huangdekai.JavaWeb.SMBMS.dao.BaseDao;
import org.junit.Test;

import java.sql.*;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/9 16:16
 * @Version: 1.0
 * @since: jdk11
 */
public class test {
    @Test
    public void testSMBMS(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/smbms?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
            String username = "root";
            String password = "qq123456";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "";
            PreparedStatement preparedStatement = connection.prepareStatement("select * from smbms_user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("name = "+resultSet.getString("userName"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

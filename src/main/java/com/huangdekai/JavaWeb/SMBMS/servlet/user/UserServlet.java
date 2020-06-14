package com.huangdekai.JavaWeb.SMBMS.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.huangdekai.JavaWeb.SMBMS.Util.Constants;
import com.huangdekai.JavaWeb.SMBMS.pojo.User;
import com.huangdekai.JavaWeb.SMBMS.service.user.UserService;
import com.huangdekai.JavaWeb.SMBMS.service.user.UserServiceImpl;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/20 2:11
 * @Version: 1.0
 * @since: jdk11
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("savepwd")){
            this.updatePassword(req, resp);
        }
        else if (method != null && method.equals("pwdmodify")){
            this.passwordModify(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    // 修改密码
    public void updatePassword(HttpServletRequest req,HttpServletResponse resp){
        // 从Session里拿Id
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);

        String newpassword = req.getParameter("newpassword");
        boolean flag = false;

        if(attribute != null && StringUtils.isNotEmpty(newpassword)){
            UserService userService = new UserServiceImpl();
            User user = (User) attribute;
            flag = userService.updatePassword(user.getId(), newpassword);


            if (flag){
                req.setAttribute(Constants.USER_MESSAGE,"修改密码成功，请退出，使用新密码登陆");
                // 密码修改成功，移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }
            else {
                req.setAttribute(Constants.USER_MESSAGE,"密码修改失败");
            }
        }
        else {
            req.setAttribute(Constants.USER_MESSAGE,"新密码有问题");
        }

        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // 验证旧密码,Session中有用户的密码
    public void passwordModify(HttpServletRequest req, HttpServletResponse resp){
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldPassword = req.getParameter("oldpassword");

        // 结果集
        Map<String,String> resultMap = new HashMap<>();

        // attribute == null  Session失效
        if (attribute == null){
            resultMap.put("result","sessionerror");
        }
        // 输入的密码为空
        else if (StringUtils.isEmpty(oldPassword)){
            resultMap.put("result","error");
        }
        else{
            String UserPassword = ((User) attribute).getUserPassword();
            if (oldPassword.equals(UserPassword)){
                resultMap.put("result","true");
            }
            else {
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();

            // JsonArray 阿里巴巴的Json工具类，转换格式
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

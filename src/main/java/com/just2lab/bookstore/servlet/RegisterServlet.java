package com.just2lab.bookstore.servlet;

import com.just2lab.bookstore.domain.User;
import com.just2lab.bookstore.exception.UserException;
import com.just2lab.bookstore.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class RegisterServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RegisterServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取验证码
        String ckcode = req.getParameter("ckcode");
        String checkcode_session = (String) req.getSession().getAttribute("checkcode_session");
        logger.info(ckcode+","+checkcode_session);
        if (ckcode == null || !ckcode.equals(checkcode_session)) {
            //验证错误
            req.setAttribute("ckcode_msg","验证错误");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }

        //成功，获取表单数据
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
            logger.info(String.valueOf(user));
            user.setActiveCode(UUID.randomUUID().toString());//手动设置激活码
            //dao存入数据库
            UserService userService = new UserService();
            userService.register(user);
            req.getSession().setAttribute("user",user);
            //跳转成功页面
            logger.info("跳转成功："+user.getGender());
            req.getRequestDispatcher("/registersuccess.jsp").forward(req, resp);

        } catch (UserException e1) {
            req.getSession().setAttribute("ckcode_msg", e1.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}

package com.just2lab.bookstore.servlet;

import com.just2lab.bookstore.domain.User;
import com.just2lab.bookstore.exception.UserException;
import com.just2lab.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取username pwd
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //查询数据库
        //有用户，存入session ，转index
        UserService us = new UserService();
        try {
            String path="/index.jsp";
            User user = us.login(username,password);
            if("admin".equals(user.getRole())){
                path="/admin/login/home.jsp";
            }
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher(path).forward(request, response);
        } catch (UserException e) {
            e.printStackTrace();
            request.setAttribute("user_msg", e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

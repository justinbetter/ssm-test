package com.just2lab.bookstore.service;

import com.just2lab.bookstore.dao.UserDao;
import com.just2lab.bookstore.domain.User;
import com.just2lab.bookstore.exception.UserException;

import java.sql.SQLException;

public class UserService {

    private UserDao dao  = new UserDao();
    public void register(User user) throws UserException {

        try {
            dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("注册失败");
        }

    }

    public void activeUser(String activeCode) throws UserException {
        //根据激活码查询数据库
        try {
            User user = dao.findUserByActiveCode(activeCode);
            if(user!=null){
                //激活用户

                dao.activeCode(activeCode);
                return;
            }
            throw new UserException("激活失败!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("激活失败!");
        }


    }

    public User login(String username, String password) throws UserException {
        User user=null;
        try {
            user = dao.findUserByUserNameAndPassword(username,password);
            if(user==null){
                throw new UserException("用户名或密码错误!");
            }
            if(user.getState()==0){
                throw new UserException("用户未激活!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("用户名或密码错误!");
        }
        return user;
    }
}

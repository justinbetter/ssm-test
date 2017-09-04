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
}

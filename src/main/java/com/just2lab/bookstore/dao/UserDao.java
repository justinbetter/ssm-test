package com.just2lab.bookstore.dao;

import com.just2lab.bookstore.domain.User;
import com.just2lab.bookstore.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {


    public void addUser(User user) throws SQLException {

        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,activecode,state,registtime) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        qr.update(sql, user.getUsername(), user.getPassword(),
                user.getGender(), user.getEmail(), user.getTelephone(),
                user.getIntroduce(), user.getActiveCode(), user.getState(),
                user.getRegistTime());


    }

    public User findUserByActiveCode(String activeCode) throws SQLException {

        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from user where activecode=?", new BeanHandler<User>(User.class),activeCode);

    }

    public void activeCode(String activeCode) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("update user set state=1 where activecode = ?", activeCode);


    }

    public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        User use = queryRunner.query("select * from user where username=? and password=? ", new BeanHandler<User>(User.class), username, password);
        return use;
    }
}

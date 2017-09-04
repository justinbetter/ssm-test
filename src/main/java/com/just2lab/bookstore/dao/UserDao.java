package com.just2lab.bookstore.dao;

import com.just2lab.bookstore.domain.User;
import com.just2lab.bookstore.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;

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
}

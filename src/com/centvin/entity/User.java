package com.centvin.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vinco on 15-4-3.
 * Entity User.
 */
public class User extends Base {
    private int user_id;
    private String userName;
    private String email;
    private String password;
    private String avatar;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public void setData(ResultSet resultSet) {
        try {
            setUser_id(resultSet.getInt("id"));
            setUserName(resultSet.getString("username"));
            setEmail(resultSet.getString("email"));
            setPassword(resultSet.getString("password"));
            setAvatar(resultSet.getString("avatar"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

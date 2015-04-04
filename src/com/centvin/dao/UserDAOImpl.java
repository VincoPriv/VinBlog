package com.centvin.dao;

import com.centvin.Utils.DBUtils;
import com.centvin.entity.Base;
import com.centvin.entity.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinco on 15-4-3.
 * Implement of UserDAO.
 */
public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT into user(username,email,password,avatar) values(?,?,?,?)";
        return DBUtils.excuteInsert(connection, sql,
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getAvatar());

    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        return DBUtils.excuteUpdate(connection, sql, id);
    }

    @Override
    public boolean deleteByEmail(String email) {
        String sql = "Delete from user where email = ?";
        return DBUtils.excuteUpdate(connection, sql, email);
    }

    @Override
    public boolean updatePassWord(int u_id, String password) {
        String query = "UPDATE user SET password = ? where id = ?";
        return DBUtils.excuteUpdate(connection,query,password,u_id);
    }

    @Override
    public boolean updateUsername(int u_id, String username) {
        String query = "UPDATE user SET username = ? where id = ?";
        return DBUtils.excuteUpdate(connection,query,username,u_id);
    }

    @Override
    public boolean updateAvator(int u_id, String avatar) {
        String sql = "Update user set avatar = ? where id= ?";
        return DBUtils.excuteUpdate(connection,sql,avatar,u_id);
    }

    @Override
    public User selectById(int id) {
        String sql = "SELECT * FROM user WHERE ID = ?";
        List<Base> users = DBUtils.excuteQuery(connection, new User(), sql, id);
        return users.isEmpty() ? null : (User) users.get(0);
    }

    @Override
    public User selectByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        List<Base> users = DBUtils.excuteQuery(connection, new User(), sql, email);
        return users.isEmpty() ? null : (User) users.get(0);
    }

    @Override
    public List<User> selectAll() {
        String sql = "select * from user";
        List<Base> users = DBUtils.excuteQuery(connection,new User(),sql);
        List<User> results = new ArrayList<User>();
        for (Base base : users){
            results.add((User)base);
        }
        return results;
    }

}

package com.centvin.dao;

import com.centvin.Utils.DBUtils;
import com.centvin.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by vinco on 15-4-3.
 * Proxy Class of UserDAO.
 */
public class UserDAOProxy implements UserDAO, Closeable{
    private Connection conn;
    private UserDAO userDAO;

    public UserDAOProxy() throws SQLException, ClassNotFoundException {
        conn = DBUtils.getConnection("account");
        userDAO = new UserDAOImpl(conn);
    }


    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userDAO.deleteById(id);
    }

    @Override
    public boolean deleteByEmail(String email) {
        return userDAO.deleteByEmail(email);
    }

    @Override
    public boolean updatePassWord(int u_id, String password) {
        return userDAO.updatePassWord(u_id,password);
    }

    @Override
    public boolean updateUsername(int u_id, String username) {
        return userDAO.updateUsername(u_id,username);
    }

    @Override
    public boolean updateAvatar(int u_id, String avator) {
        return userDAO.updateAvatar(u_id, avator);
    }

    @Override
    public User selectById(int id) {
        return userDAO.selectById(id);
    }

    @Override
    public User selectByEmail(String email) {
        return userDAO.selectByEmail(email);
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public void close() {
        DBUtils.releaseDB(conn,null,null);
    }

}

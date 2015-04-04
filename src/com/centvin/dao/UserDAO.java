package com.centvin.dao;

import com.centvin.entity.User;

import java.util.List;

/**
 * Created by vinco on 15-4-3.
 * Interface DAO for User.
 */
public interface UserDAO {
    public int insert(User user);

    public boolean deleteById(int id);
    public boolean deleteByEmail(String email);

    public boolean updatePassWord(int u_id, String password);
    public boolean updateUsername(int u_id, String username);
    public boolean updateAvator(int u_id, String avator);

    public User selectById(int id);
    public User selectByEmail(String email);
    public List<User> selectAll();
}

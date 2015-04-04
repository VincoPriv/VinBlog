package com.centvin.test.dao;

import com.centvin.dao.Closeable;
import com.centvin.dao.UserDAO;
import com.centvin.dao.UserDAOProxy;
import com.centvin.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by vinco on 15-4-3.
 * Test class for UserDAO,UserDAOImpl,UserDAOProxy
 */
public class TestUserDAO {
    private UserDAO userDAO;
    private User user4test = new User();

    {
        user4test.setUserName("testVinco2");
        user4test.setEmail("testvinco2@gmail.com");
        user4test.setPassword("echo");
        user4test.setAvatar("testecho.jpg");
    }


    @Before
    public void before() throws SQLException, ClassNotFoundException {
        userDAO = new UserDAOProxy();
        int id = userDAO.insert(user4test);
        Assert.assertTrue(id != -1);
        user4test.setUser_id(id);
    }

    @After
    public void after() {
        boolean dele = userDAO.deleteByEmail(user4test.getEmail());
        Assert.assertTrue(dele);
        Assert.assertTrue(userDAO.selectById(user4test.getUser_id()) == null);
        ((Closeable) userDAO).close();
    }

    @Test
    public void testSelectUserByEmail() {
        User user = userDAO.selectByEmail("testvinco2@gmail.com");
        if (user != null) {
            Assert.assertEquals(user4test.getPassword(), user.getPassword());
            Assert.assertEquals(user4test.getUserName(), user.getUserName());
        }
    }

    @Test
    public void testSelectUserById() {
        User user = userDAO.selectById(user4test.getUser_id());
        Assert.assertTrue(user != null);
        Assert.assertEquals(user4test.getUserName(), user.getUserName());
        Assert.assertEquals(user4test.getEmail(), user.getEmail());
    }

    @Test
    public void testUpdatePassword() {
        Assert.assertTrue(userDAO.updatePassWord(user4test.getUser_id(), "TsetForChangePWD"));
        User user = userDAO.selectById(user4test.getUser_id());
        Assert.assertEquals("TsetForChangePWD", user.getPassword());
    }

    @Test
    public void testUpdateUserName() {
        Assert.assertTrue(userDAO.updateUsername(user4test.getUser_id(), "vinco4testcg"));
        User user = userDAO.selectById(user4test.getUser_id());
        Assert.assertEquals("vinco4testcg", user.getUserName());
    }

    @Test
    public void testUpdateAvatar() {
        Assert.assertTrue(userDAO.updateAvatar(user4test.getUser_id(), "newavatar.jpg"));
        User user = userDAO.selectById(user4test.getUser_id());
        Assert.assertEquals("newavatar.jpg", user.getAvatar());
    }
}

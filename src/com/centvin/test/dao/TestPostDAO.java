package com.centvin.test.dao;

import com.centvin.dao.Closeable;
import com.centvin.dao.PostDAO;
import com.centvin.dao.PostDAOProxy;
import com.centvin.entity.Post;
import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by vinco on 15-4-4.
 */
public class TestPostDAO {
    private Post testPost = new Post();
    private PostDAO postDAO;
    @Before
    public void before() throws SQLException, ClassNotFoundException {
        testPost.setTitle("Welcome to Vinblog");
        testPost.setContent("This is a blog system created by vinco zhang, a student from sichuan university");
        Date time = new Date(System.currentTimeMillis());
        testPost.setCreated_at(time);

        postDAO = new PostDAOProxy("vinco");

        int id = postDAO.insert(testPost);
        Assert.assertTrue(id >= 1);
        testPost.setPost_id(id);
    }

    @After
    public void after(){
        postDAO.deleteById(testPost.getPost_id());
        ((Closeable)postDAO).close();
    }
    @Test
    public void testUpdateTitle(){
        Assert.assertTrue(postDAO.updateTitle(testPost.getPost_id(),"New title for the test"));
        Post tmpPost = postDAO.selectById(testPost.getPost_id());
        Assert.assertTrue(tmpPost != null);
        Assert.assertEquals("New title for the test", tmpPost.getTitle());
    }
    @Test
    public void testUpdateContent(){
        Assert.assertTrue(postDAO.updateContent(testPost.getPost_id(),"This is changed content for test."));
        Post tmpPost = postDAO.selectById(testPost.getPost_id());
        Assert.assertTrue(tmpPost!=null);
        Assert.assertEquals("This is changed content for test.",tmpPost.getContent());
    }

}

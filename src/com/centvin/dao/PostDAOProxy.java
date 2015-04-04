package com.centvin.dao;

import com.centvin.Utils.DBUtils;
import com.centvin.entity.Post;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vinco on 15-4-4.
 * Proxy class fro PostDAO.
 */
public class PostDAOProxy implements PostDAO,Closeable {


    private PostDAO postDAO;
    Connection conn;
    public PostDAOProxy(String userdb) throws SQLException, ClassNotFoundException {
        conn = DBUtils.getConnection(userdb);
        postDAO = new PostDAOImpl(conn);
    }

    @Override
    public int insert(Post post) {
        return postDAO.insert(post);
    }

    @Override
    public boolean deleteById(int post_id) {
        return postDAO.deleteById(post_id);
    }

    @Override
    public boolean updateTitle(int post_id, String title) {
        return postDAO.updateTitle(post_id, title);
    }

    @Override
    public boolean updateContent(int post_id, String content) {
        return postDAO.updateContent(post_id,content);
    }

    @Override
    public Post selectById(int post_id) {
        return postDAO.selectById(post_id);
    }

    @Override
    public void close() {
        DBUtils.releaseDB(conn,null,null);
    }
}

package com.centvin.dao;

import com.centvin.Utils.DBUtils;
import com.centvin.entity.Base;
import com.centvin.entity.Post;

import java.sql.Connection;
import java.util.List;

/**
 * Created by vinco on 15-4-4.
 * Implement Class for PostDAO.
 */
public class PostDAOImpl implements PostDAO {
    private Connection conn;

    public PostDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int insert(Post post) {
        String sql="insert into posts(title,create_time,content) values(?, ?, ?) ";
        return DBUtils.excuteInsert(conn,sql,post.getTitle(),post.getCreated_at(),post.getContent());
    }

    @Override
    public boolean deleteById(int post_id) {
        String sql= "delete from posts where id = ? ";
        return DBUtils.excuteUpdate(conn,sql,post_id);
    }

    @Override
    public boolean updateTitle(int post_id, String title) {
        String sql = "update posts set title = ? where id =?";

        return DBUtils.excuteUpdate(conn,sql,title,post_id);
    }

    @Override
    public boolean updateContent(int post_id, String content) {
        String sql = "update posts set content = ? where id = ?";
        return DBUtils.excuteUpdate(conn,sql,content,post_id);
    }

    @Override
    public Post selectById(int post_id) {
        String sql = "select * from posts where id = ?";
        List<Base> resuts = DBUtils.excuteQuery(conn,new Post(),sql,post_id);
        return resuts.isEmpty()?null:(Post)resuts.get(0);
    }

}

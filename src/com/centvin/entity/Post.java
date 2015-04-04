package com.centvin.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vinco on 15-4-3.
 * Entity Post.
 */
public class Post extends Base {
    private int post_id;

    private String title;
    private Date created_at;
    private Date updated_at;
    private String content;

    private List<Tag> tags = new ArrayList<Tag>();
    private List<Comment> comments = new ArrayList<Comment>();

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public void setData(ResultSet resultSet) {
        try {
            setPost_id(resultSet.getInt("id"));
            setContent(resultSet.getString("content"));
            setTitle(resultSet.getString("title"));
            setCreated_at(resultSet.getDate("create_time"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

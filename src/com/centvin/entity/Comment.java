package com.centvin.entity;

import java.sql.ResultSet;

/**
 * Created by vinco on 15-4-3.
 * Entity Comment.
 */
public class Comment extends Base {
    private int comment_id;
    private String userName;
    private String email;
    private String content;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //TODO
    @Override
    public void setData(ResultSet resultSet) {

    }
}

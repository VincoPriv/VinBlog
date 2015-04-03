package com.centvin.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinco on 15-4-3.
 * Entity Tag
 */
public class Tag {
    private int tag_id;
    private String name;
    private List<Post> posts = new ArrayList<Post>();

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPost() {
        return posts;
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
    }
}

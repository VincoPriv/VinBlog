package com.centvin.dao;

import com.centvin.entity.Post;

/**
 * Created by vinco on 15-4-4.
 * Interface for accessing table Post.
 */
public interface PostDAO {
    public int insert(Post post);

    public boolean deleteById(int post_id);

    public boolean updateTitle(int post_id,String title);
    public boolean updateContent(int post_id,String content);

    public Post selectById(int post_id);

}

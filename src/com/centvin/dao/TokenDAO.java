package com.centvin.dao;

import com.centvin.entity.Token;

/**
 * Created by vinco on 15-4-6.
 * Interfaces defined for token.
 */
public interface TokenDAO {
    public boolean insert(Token token);

    public boolean delete(String username);

    public boolean update(Token token);
    public boolean update(String username,String token);

    public Token select(String username);
}

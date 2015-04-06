package com.centvin.dao;

import com.centvin.Utils.DBUtils;
import com.centvin.entity.Token;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vinco on 15-4-6.
 */
public class TokenDAOProxy implements TokenDAO {
    TokenDAO tokenDAO = null;
    public TokenDAOProxy() throws SQLException, ClassNotFoundException {
        Connection conn = DBUtils.getConnection("account");
        tokenDAO = new TokenDAOImpl(conn);
    }

    @Override
    public boolean insert(Token token) {
        return tokenDAO.insert(token);
    }

    @Override
    public boolean delete(String username) {
        return tokenDAO.delete(username);
    }

    @Override
    public boolean update(Token token) {
        return tokenDAO.update(token.getUsername(),token.getToken());
    }

    @Override
    public boolean update(String username, String token) {
        return tokenDAO.update(username,token);
    }

    @Override
    public Token select(String username) {
        return tokenDAO.select(username);
    }
}

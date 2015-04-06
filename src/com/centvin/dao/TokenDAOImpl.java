package com.centvin.dao;

import com.centvin.Utils.DBUtils;
import com.centvin.entity.Base;
import com.centvin.entity.Token;

import java.sql.Connection;
import java.util.List;

/**
 * Created by vinco on 15-4-6.
 */
public class TokenDAOImpl implements TokenDAO {

    Connection conn = null;

    public TokenDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(Token token) {
        String sql = "insert into token(username,token) values(?,?)";
        return DBUtils.excuteInsert(conn,sql,token.getUsername(),token.getToken()) >=1;
    }

    @Override
    public boolean delete(String username) {
        String sql = "delete from token where username = ?";
        return DBUtils.excuteUpdate(conn,sql,username);
    }

    @Override
    public boolean update(Token token) {
        String sql = "update token set token = ? where username = ? ";
        return DBUtils.excuteUpdate(conn,sql,token.getToken(),token.getUsername());
    }

    @Override
    public boolean update(String username, String token) {
        String sql = "Update token set token = ? where username = ?";
        return  DBUtils.excuteUpdate(conn,sql,token,username);
    }

    @Override
    public Token select(String username) {
        String sql = "select * from token where username = ?";
        List<Base> res = DBUtils.excuteQuery(conn,new Token(),sql,username);
        return res.isEmpty() ? null : (Token)res.get(0);
    }
}

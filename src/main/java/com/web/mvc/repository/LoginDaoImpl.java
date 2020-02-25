package com.web.mvc.repository;

import com.web.mvc.entity.Member;
import com.web.mvc.repository.spec.LoginDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Member member) {
        String sql = "INSERT INTO MEMBER(username, password, email, code, priority, pass) VALUES(?, ?, ?, ?, ?, ?)";
        int rowcount = jdbcTemplate.update(sql, member.getUsername(), member.getPassword(), member.getEmail(), member.getCode(), member.getPriority(), member.getPass());
        return rowcount;
    }

    @Override
    public boolean findUsername(String username) {
        String sql = "SELECT * FROM MEMBER WHERE username=?";
        List list = jdbcTemplate.queryForList(sql, username);
        return list.size() >= 1 ? true : false;
    }

    @Override
    public boolean verifyEmailCode(String username, String code) {
        String sql = "UPDATE MEMBER SET pass=?, passts=? WHERE username=? AND code=?";
        int rowcount = jdbcTemplate.update(sql, true, new Date(), username, code);
        return rowcount >= 1 ? true : false;
    }

    @Override
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM MEMBER WHERE username=? AND password=?";
        List list = jdbcTemplate.queryForList(sql, username, password);
        return list.size() >= 1 ? true : false;
    }
    
}

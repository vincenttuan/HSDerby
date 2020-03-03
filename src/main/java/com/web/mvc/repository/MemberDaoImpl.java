package com.web.mvc.repository;

import com.web.mvc.entity.Member;
import com.web.mvc.repository.spec.MemberDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Member> query() {
        String sql = "SELECT * FROM MEMBER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class));
    }
    
}

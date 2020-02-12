package com.web.mvc.repository;

import com.web.mvc.repository.spec.ChartDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDaoImpl implements ChartDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List queryProductQuantity() {
        String sql = "SELECT p.DESCRIPTION, p.QUANTITY_ON_HAND FROM PRODUCT p";
        return jdbcTemplate.queryForList(sql);
    }
    
}

package com.web.mvc.repository;

import com.web.mvc.entity.DiscountCode;
import com.web.mvc.repository.spec.DiscountCodeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountCodeDaoImpl implements DiscountCodeDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<DiscountCode> queryDiscountCode() {
        String sql = "SELECT * FROM DISCOUNT_CODE";
        RowMapper<DiscountCode> rowMapper = (rs, i) -> {
            DiscountCode dc = new DiscountCode();
            dc.setDiscountCode(rs.getString("DISCOUNT_CODE"));
            dc.setRate(rs.getDouble("RATE"));
            return dc;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public DiscountCode getDiscountCode(String code) {
        String sql = "SELECT * FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        DiscountCode dc = jdbcTemplate.queryForObject(sql, new Object[]{code}, new BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
        return dc;
    }

    @Override
    public void saveDiscountCode(DiscountCode dc) {
        String sql = "INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE, RATE) VALUES(?, ?)";
        jdbcTemplate.update(sql, dc.getDiscountCode(), dc.getRate());
    }

    @Override
    public void updateDiscountCode(DiscountCode dc) {
        String sql = "UPDATE DISCOUNT_CODE SET RATE = ? WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, dc.getRate(), dc.getDiscountCode());
    }

    @Override
    public void deleteDiscountCode(String code) {
        String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, code);
    }
    
}

package com.web.mvc.repository;

import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.MicroMarketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MicroMarketDaoImpl implements MicroMarketDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<MicroMarket> queryMicroMarket() {
        String sql = "SELECT * FROM MICRO_MARKET";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MicroMarket>(MicroMarket.class));
    }

    @Override
    public MicroMarket getMicroMarket(String zipCode) {
        String sql = "SELECT * FROM MICRO_MARKET WHERE ZIP_CODE = ?";
        MicroMarket mm = jdbcTemplate.queryForObject(sql, new Object[]{zipCode}, new BeanPropertyRowMapper<MicroMarket>(MicroMarket.class));
        return mm;
    }

    @Override
    public void saveMicroMarket(MicroMarket mm) {
        String sql = "INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, mm.getZipCode(), mm.getRadius(), mm.getAreaLength(), mm.getAreaWidth());
    }

    @Override
    public void updateMicroMarket(MicroMarket mm) {
        String sql = "UPDATE MICRO_MARKET SET RADIUS=?, AREA_LENGTH=?, AREA_WIDTH=? WHERE ZIP_CODE = ?";
        jdbcTemplate.update(sql, mm.getRadius(), mm.getAreaLength(), mm.getAreaWidth(), mm.getZipCode());
    }

    @Override
    public void deleteMicroMarket(String zipCode) {
        String sql = "DELETE FROM MICRO_MARKET WHERE ZIP_CODE = ?";
        jdbcTemplate.update(sql, zipCode);
    }
    
}

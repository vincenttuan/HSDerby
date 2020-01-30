package com.web.mvc.repository;

import com.web.mvc.entity.Manufacturer;
import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.ManufacturerDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Manufacturer> queryManufacturer() {
        String sql = "SELECT * FROM MANUFACTURER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class));
    }

    @Override
    public Manufacturer getManufacturer(Integer id) {
        String sql = "SELECT * FROM MANUFACTURER WHERE MANUFACTURER_ID = ?";
        Manufacturer mf = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class));
        return mf;
    }

    @Override
    public void saveManufacturer(Manufacturer mf) {
        String sql = "INSERT INTO MANUFACTURER("
                + "MANUFACTURER_ID, NAME, ADDRESSLINE1, ADDRESSLINE2,"
                + "CITY, STATE, ZIP, PHONE, FAX, EMAIL, REP) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                mf.getManufacturerId(), mf.getName(), mf.getAddressline1(), mf.getAddressline2(),
                mf.getCity(), mf.getState(), mf.getZip(), mf.getPhone(), mf.getFax(), mf.getEmail(), mf.getRep()
        );
    }
    
    @Override
    public void updateManufacturer(Manufacturer mf) {
        String sql = "UPDATE MANUFACTURER SET "
                + "NAME = ?, ADDRESSLINE1 = ?, ADDRESSLINE2 = ?,"
                + "CITY = ?, STATE = ?, ZIP = ?, PHONE = ?, FAX = ?, EMAIL = ?, REP = ? "
                + "WHERE MANUFACTURER_ID = ?";
        jdbcTemplate.update(sql,
                mf.getName(), mf.getAddressline1(), mf.getAddressline2(),
                mf.getCity(), mf.getState(), mf.getZip(), mf.getPhone(), mf.getFax(), mf.getEmail(), mf.getRep(),
                mf.getManufacturerId()
        );
    }

    @Override
    public void deleteManufacturer(Integer id) {
        String sql = "DELETE FROM MANUFACTURER WHERE MANUFACTURER_ID = ?";
        jdbcTemplate.update(sql, id);
    }

}

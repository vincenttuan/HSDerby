package com.web.mvc.repository;

import com.web.mvc.entity.ProductCode;
import com.web.mvc.repository.spec.ProductCodeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCodeDaoImpl implements ProductCodeDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ProductCode> queryProductCode() {
        String sql = "SELECT * FROM PRODUCT_CODE";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductCode>(ProductCode.class));
    }

    @Override
    public ProductCode getProductCode(String code) {
        String sql = "SELECT * FROM PRODUCT_CODE WHERE PROD_CODE = ?";
        ProductCode pc = jdbcTemplate.queryForObject(sql, new Object[]{code}, new BeanPropertyRowMapper<ProductCode>(ProductCode.class));
        return pc;
    }

    @Override
    public void saveProductCode(ProductCode pc) {
        String sql = "INSERT INTO PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, pc.getProdCode(), pc.getDiscountCode(), pc.getDescription());
    }

    @Override
    public void updateProductCode(ProductCode pc) {
        String sql = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE=?, DESCRIPTION=? WHERE PROD_CODE=?";
        jdbcTemplate.update(sql, pc.getDiscountCode(), pc.getDescription(), pc.getProdCode());
    }

    @Override
    public void deleteProductCode(String code) {
        String sql = "DELETE FROM PRODUCT_CODE WHERE PROD_CODE = ?";
        jdbcTemplate.update(sql, code);
    }
    
}

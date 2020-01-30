package com.web.mvc.repository;

import com.web.mvc.entity.Product;
import com.web.mvc.repository.spec.ProductDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Product> queryProduct() {
        String sql = "SELECT * FROM PRODUCT";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public Product getProduct(Integer id) {
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
        Product p = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));
        return p;
    }

    @Override
    public void saveProduct(Product p) {
        String sql = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, p.getProductId(), p.getManufacturerId(), p.getProductCode(), p.getPurchaseCost(), p.getQuantityOnHand(), p.getMarkup(), p.getAvailable(), p.getDescription());
    }

    @Override
    public void updateProduct(Product p) {
        String sql = "UPDATE PRODUCT SET MANUFACTURER_ID=?, PRODUCT_CODE=?, PURCHASE_COST=?, QUANTITY_ON_HAND=?, MARKUP=?, AVAILABLE=?, DESCRIPTION=? WHERE PRODUCT_ID=?";
        jdbcTemplate.update(sql, p.getManufacturerId(), p.getProductCode(), p.getPurchaseCost(), p.getQuantityOnHand(), p.getMarkup(), p.getAvailable(), p.getDescription(), p.getProductId());
    }

    @Override
    public void deleteProduct(Integer id) {
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        jdbcTemplate.update(sql, id);
    }
    
}

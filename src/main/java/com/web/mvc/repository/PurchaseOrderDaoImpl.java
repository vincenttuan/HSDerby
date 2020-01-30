package com.web.mvc.repository;

import com.web.mvc.entity.PurchaseOrder;
import com.web.mvc.repository.spec.PurchaseOrderDao;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<PurchaseOrder> queryPurchaseOrder() {
        String sql = "SELECT * FROM PURCHASE_ORDER";
        List<PurchaseOrder> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return list;
    }

    @Override
    public PurchaseOrder getPurchaseOrder(Integer num) {
        String sql = "SELECT * FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        PurchaseOrder purchaseOrder = jdbcTemplate.queryForObject(sql, new Object[]{num}, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return purchaseOrder;
    }

    @Override
    public void savePurchaseOrder(PurchaseOrder purchaseOrder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO PURCHASE_ORDER("
                + "ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, "
                + "SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                purchaseOrder.getOrderNum(),
                purchaseOrder.getCustomerId(),
                purchaseOrder.getProductId(),
                purchaseOrder.getQuantity(),
                purchaseOrder.getShippingCost(),
                sdf.format(purchaseOrder.getSalesDate()),
                sdf.format(purchaseOrder.getShippingDate()),
                purchaseOrder.getFreightCompany());
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE PURCHASE_ORDER SET "
                + "CUSTOMER_ID=?, PRODUCT_ID=?, QUANTITY=?, "
                + "SHIPPING_COST=?, SALES_DATE=?, SHIPPING_DATE=?, FREIGHT_COMPANY=? "
                + "WHERE ORDER_NUM=?";
        jdbcTemplate.update(sql,
                purchaseOrder.getCustomerId(),
                purchaseOrder.getProductId(),
                purchaseOrder.getQuantity(),
                purchaseOrder.getShippingCost(),
                sdf.format(purchaseOrder.getSalesDate()),
                sdf.format(purchaseOrder.getShippingDate()),
                purchaseOrder.getFreightCompany(),
                purchaseOrder.getOrderNum());
    }

    @Override
    public void deletePurchaseOrder(Integer num) {
        String sql = "DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        jdbcTemplate.update(sql, num);
    }
    
}

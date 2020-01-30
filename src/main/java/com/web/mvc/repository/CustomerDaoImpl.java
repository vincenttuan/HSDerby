package com.web.mvc.repository;

import com.web.mvc.entity.Customer;
import com.web.mvc.repository.spec.CustomerDao;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> queryCustomer() {
        String sql = "SELECT * FROM CUSTOMER";
        RowMapper<Customer> rowMapper = (ResultSet rs, int rowNum) -> {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
            customer.setDiscountCode(rs.getString("DISCOUNT_CODE"));
            customer.setZip(rs.getString("ZIP"));
            customer.setName(rs.getString("NAME"));
            customer.setAddressLine1(rs.getString("ADDRESSLINE1"));
            customer.setAddressLine2(rs.getString("ADDRESSLINE2"));
            customer.setCity(rs.getString("CITY"));
            customer.setState(rs.getString("STATE"));
            customer.setPhone(rs.getString("PHONE"));
            customer.setFax(rs.getString("FAX"));
            customer.setEmail(rs.getString("EMAIL"));
            customer.setCreditLimit(rs.getInt("CREDIT_LIMIT"));
            return customer;
        };
        List<Customer> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override

    public Customer getCustomer(Integer id) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        Customer cust = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
        return cust;
    }

    @Override
    public void saveCustomer(Customer cust) {
        String sql = "INSERT INTO CUSTOMER(CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, "
                + "ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(cust);
        jdbcTemplate.update(sql,
                cust.getCustomerId(),
                cust.getDiscountCode(),
                cust.getZip(),
                cust.getName(),
                cust.getAddressLine1(),
                cust.getAddressLine2(),
                cust.getCity(),
                cust.getState(),
                cust.getPhone(),
                cust.getFax(),
                cust.getEmail(),
                cust.getCreditLimit());
    }

    @Override
    public void updateCustomer(Customer cust) {
        String sql = "UPDATE CUSTOMER SET "
                + "DISCOUNT_CODE=?, ZIP=?, NAME=?, ADDRESSLINE1=?, "
                + "ADDRESSLINE2=?, CITY=?, STATE=?, PHONE=?, "
                + "FAX=?, EMAIL=?, CREDIT_LIMIT=? "
                + "WHERE CUSTOMER_ID = ?";
        jdbcTemplate.update(sql,
                cust.getDiscountCode(),
                cust.getZip(),
                cust.getName(),
                cust.getAddressLine1(),
                cust.getAddressLine2(),
                cust.getCity(),
                cust.getState(),
                cust.getPhone(),
                cust.getFax(),
                cust.getEmail(),
                cust.getCreditLimit(),
                cust.getCustomerId());
    }

    @Override
    public void deleteCustomer(Integer id) {
        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        jdbcTemplate.update(sql, id);
    }

}

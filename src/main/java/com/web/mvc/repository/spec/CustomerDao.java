package com.web.mvc.repository.spec;

import com.web.mvc.entity.Customer;
import java.util.List;

public interface CustomerDao {

    List<Customer> queryCustomer();

    Customer getCustomer(Integer id);

    void saveCustomer(Customer cust);

    void updateCustomer(Customer cust);

    void deleteCustomer(Integer id);

}

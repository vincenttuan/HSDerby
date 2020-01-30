package com.web.mvc.repository.spec;

import com.web.mvc.entity.Product;
import java.util.List;

public interface ProductDao {

    List<Product> queryProduct();

    Product getProduct(Integer id);

    void saveProduct(Product p);

    void updateProduct(Product p);

    void deleteProduct(Integer id);

}

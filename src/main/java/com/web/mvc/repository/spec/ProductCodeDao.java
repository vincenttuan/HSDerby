package com.web.mvc.repository.spec;

import com.web.mvc.entity.ProductCode;
import java.util.List;

public interface ProductCodeDao {

    List<ProductCode> queryProductCode();

    ProductCode getProductCode(String code);

    void saveProductCode(ProductCode pc);

    void updateProductCode(ProductCode pc);

    void deleteProductCode(String code);

}

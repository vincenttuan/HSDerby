package com.web.mvc.repository.spec;

import com.web.mvc.entity.DiscountCode;
import java.util.List;

public interface DiscountCodeDao {

    List<DiscountCode> queryDiscountCode();

    DiscountCode getDiscountCode(String code);

    void saveDiscountCode(DiscountCode dc);

    void updateDiscountCode(DiscountCode dc);

    void deleteDiscountCode(String code);

}

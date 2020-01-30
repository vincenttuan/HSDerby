package com.web.mvc.repository.spec;

import com.web.mvc.entity.MicroMarket;
import java.util.List;

public interface MicroMarketDao {

    List<MicroMarket> queryMicroMarket();

    MicroMarket getMicroMarket(String zipCode);

    void saveMicroMarket(MicroMarket mm);

    void updateMicroMarket(MicroMarket mm);

    void deleteMicroMarket(String zipCode);

}

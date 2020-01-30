package com.web.mvc.repository.spec;

import com.web.mvc.entity.Manufacturer;
import java.util.List;

public interface ManufacturerDao {

    List<Manufacturer> queryManufacturer();

    Manufacturer getManufacturer(Integer id);

    void saveManufacturer(Manufacturer mf);

    void updateManufacturer(Manufacturer mf);

    void deleteManufacturer(Integer id);

}

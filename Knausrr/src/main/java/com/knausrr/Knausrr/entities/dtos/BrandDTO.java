package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class BrandDTO {
    /* START - members */
    private UUID id;
    private String name;
    /* END - members */

    /* START - references */
    private List<BaseProductDTO> base_products;
    /* END - references */

    /* START - constructors */

    public BrandDTO() {
    }

    public BrandDTO(Brand b) {
        this.id = b.getId();
        this.name = b.getName();
    }
    /* END - constructors */

    /* START - getter */

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<BaseProductDTO> getBase_products() {
        return base_products;
    }
    /* END - getter */

    /* START - setter */

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBase_products(List<Base_Product> base_products, ExposureLevel exLvl) {
        this.base_products = base_products.stream().map(bp -> Base_Product.buildDto(bp, exLvl)).toList();
    }
    /* END - setter */
}

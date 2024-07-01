package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.Company;
import com.knausrr.Knausrr.entities.Store;
import jakarta.persistence.*;

import java.util.List;

public class CompanyDTO {
    /* START - members */
    private Long id;
    private String name;
    private byte [] logo;
    /* END - members */

    /* START - references */
    private List<StoreDTO> stores;
    /* END - references */

    /* START - constructors */

    public CompanyDTO() {
    }

    public CompanyDTO(Company company, ExposureLevel exLvl) {
        this.id = company.getId();
        this.name = company.getName();
        this.logo = company.getLogo();
    }
    /* END - constructors */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public List<StoreDTO> getStores() {
        return stores;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public void setStores(List<Store> stores, ExposureLevel exLvl) {
        this.stores = stores.stream().map(s -> Store.buildDto(s, exLvl)).toList();
    }
    /* END - setter */
}

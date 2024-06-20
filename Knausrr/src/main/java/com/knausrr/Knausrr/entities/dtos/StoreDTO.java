package com.knausrr.Knausrr.entities.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.knausrr.Knausrr.entities.Address;
import com.knausrr.Knausrr.entities.Company;
import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.entities.Store;

import java.util.List;

public class StoreDTO {
    /* START - members */
    private  Long id;
    private  String name;
    /* END - members */

    /* START - references */
    private  Address address;
    private  Company company;
    private List<Local_Product> localProducts;
    /* END - references */

    /* START - constructor */

    public StoreDTO() {
    }

    public StoreDTO(Store st){
        this.id = st.getId();
        this.name = st.getName();
        this.address = st.getAddress();
        this.company = st.getCompany();
        this.localProducts = st.getLocalProducts();
    }

    public StoreDTO(Long id, String name, Address address, Company company, List<Local_Product> localProducts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.company = company;
        this.localProducts = localProducts;
    }
    /* END - constructor */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    public List<Local_Product> getLocalProducts() {
        return localProducts;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setLocalProducts(List<Local_Product> localProducts) {
        this.localProducts = localProducts;
    }
    /* END - setter */

}

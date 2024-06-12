package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.Address;
import com.knausrr.Knausrr.entities.Company;
import com.knausrr.Knausrr.entities.Local_Product;

import java.util.List;

public class StoreDTO {
    /* START - store */
    private final Long id;
    private final String name;
    private final Address address;
    /* END - store */

    /* START - company */
    private final Company company;
    /* END - company */

    /* START - localProducts */
    private final List<Local_Product> localProducts;
    /* END - localProducts */

    /* START - constructor */
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

}

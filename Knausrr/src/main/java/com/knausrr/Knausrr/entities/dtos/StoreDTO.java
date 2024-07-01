package com.knausrr.Knausrr.entities.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.knausrr.Knausrr.entities.*;
import org.springframework.cglib.core.Local;

import java.util.List;

public class StoreDTO {
    /* START - members */
    private  Long id;
    private  String name;
    /* END - members */

    /* START - references */
    private  AddressDTO address;
    private  CompanyDTO company;
    private List<LocalProductDTO> localProducts;
    private List<OpeningHoursDTO> openingHours;
    private ContactDTO manager;
    /* END - references */

    /* START - constructor */

    public StoreDTO() {
    }

    public StoreDTO(Store st, ExposureLevel exLvl){
        this.id = st.getId();
        this.name = st.getName();
    }
    /* END - constructor */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public List<LocalProductDTO> getLocalProducts() {
        return localProducts;
    }

    public ContactDTO getManager() {
        return manager;
    }

    public List<OpeningHoursDTO> getOpeningHours() {
        return openingHours;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address, ExposureLevel exLvl) {
        this.address = Address.buildDto(address, exLvl);
    }

    public void setCompany(Company company, ExposureLevel exLvl) {
        this.company = Company.buildDto(company, exLvl);
    }

    public void setLocalProducts(List<Local_Product> localProducts, ExposureLevel exLvl) {
        this.localProducts = localProducts.stream().map(lp -> Local_Product.buildDto(lp, exLvl)).toList();
    }

    public void setManager(Contact manager, ExposureLevel exLvl) {
        this.manager = Contact.buildDto(manager, exLvl);
    }

    public void setOpeningHours(List<OpeningHours> openingHours, ExposureLevel exLvl) {
        this.openingHours = openingHours.stream().map(oh -> OpeningHours.buildDto(oh, exLvl)).toList();
    }
    /* END - setter */

}

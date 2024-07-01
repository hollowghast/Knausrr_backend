package com.knausrr.Knausrr.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.knausrr.Knausrr.entities.Address;
import com.knausrr.Knausrr.entities.Store;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public class AddressDTO {

    /* START - members */
    private Long id;
    private String country;
    private String district;
    private String zipcode;
    private String city;
    private String street;
    private String details;
    /* END - members */

    /* START - references */
    private StoreDTO store;
    /* END - references */

    /* START - constructors */

    public AddressDTO() {
    }

    public AddressDTO(Address address, ExposureLevel exLvl) {
        this.id = address.getId();
        this.country = address.getCountry();
        this.district = address.getDistrict();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.details = address.getDetails();
    }
    /* END - constructors */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getDetails() {
        return details;
    }

    public StoreDTO getStore() {
        return store;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStore(Store store, ExposureLevel exLvl) {
        this.store = Store.buildDto(store, exLvl);
    }
    /* END - setter */
}

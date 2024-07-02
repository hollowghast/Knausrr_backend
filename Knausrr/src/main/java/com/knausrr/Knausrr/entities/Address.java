package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.knausrr.Knausrr.entities.dtos.AddressDTO;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.StoreDTO;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@NamedNativeQueries({

})
public class Address {
    /* START - members */
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    @Column(name = "address_id")
    private UUID id;
    @Column(nullable = false)
    private String country;
    private String district;
    @Column(nullable = false)
    private String zipcode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String details;
    //add unique key for country-city-street-details (special treatment for details)
    /* END - members */

    /* START - references */
    @OneToOne(mappedBy = "address")
    private Store store;
    /* END - references */

    /* START - constructors */
    public Address(AddressDTO address) {
        this.id = address.getId();
        this.country = address.getCountry();
        this.district = address.getDistrict();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.details = address.getDetails();

        this.store = new Store(address.getStore());
    }

    public Address() {
    }
    /* END - constructors */

    public final static AddressDTO buildDto(Address address, ExposureLevel exLvl){
        DTOBuilder<AddressDTO> addressDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                addressDtoBuilder = DTOBuilder.of(() -> new AddressDTO(address, exLvl));
            }
        }

        return Objects.isNull(addressDtoBuilder) ? null : addressDtoBuilder.build();
    }

    /* START - getter */
    public UUID getId() {
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

    public Store getStore() {
        return store;
    }
    /* END - getter */

    /* START - setter */

    public void setId(UUID id) {
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

    public void setStore(Store store) {
        this.store = store;
    }
    /* END - setter */
}

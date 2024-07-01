package com.knausrr.Knausrr.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.LocalProductDTO;
import com.knausrr.Knausrr.entities.dtos.StoreDTO;
import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

@Entity
public class Store {
    /* START - members */
    @Id
    @SequenceGenerator(
            name = "seq_Store",
            sequenceName = "seq_Store",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Store"
    )
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name", nullable = false)
    private String name;
    /**
     * accepted currencies (CH -> CHF/EUR)
     */
    private List<Currency> currencies;
    /* END - members */

    /* START - references */
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<Local_Product> localProducts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<OpeningHours> openingHours;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", nullable = false)
    private Contact manager;
    /* END - references */

    /* START - constructors */
    public Store(Company company, Address address) {
        this.company = company;
        this.address = address;
        currencies = new ArrayList<Currency>();
    }

    public Store(String name, Company company, Address address) {
        this.name = name;
        this.company = company;
        this.address = address;
    }

    public Store() {
        currencies = new ArrayList<Currency>();
    }
    /* END - constructors */

    public final static StoreDTO buildDto(Store store, ExposureLevel exLvl){
        DTOBuilder<StoreDTO> storeDtoBuilder = null;

        switch (exLvl){
            case EXTENDED: // for unidirectional references
            case COMPLETE:
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store, exLvl))
                    .with((storedto, empty) -> {
                        storedto.setAddress(store.getAddress(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setCompany(store.getCompany(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setManager(store.getManager(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setLocalProducts(store.getLocalProducts(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setOpeningHours(store.getOpeningHours(), exLvl);
                    }, null);
            case FAST:
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store, exLvl))
                    .with((storedto, empty) -> {
                        storedto.setAddress(store.getAddress(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setCompany(store.getCompany(), exLvl);
                    }, null);
            case MINIMAL:
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store, exLvl))
                    .with((storedto, empty) -> {
                        storedto.setAddress(store.getAddress(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setCompany(store.getCompany(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setManager(store.getManager(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setLocalProducts(store.getLocalProducts(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setOpeningHours(store.getOpeningHours(), exLvl);
                    }, null);
            case STANDARD :
            default: {
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store, exLvl))
                        .with((storedto, empty) -> {
                            storedto.setAddress(store.getAddress(), exLvl);
                        }, null);

            }
        }

        return Objects.isNull(storeDtoBuilder) ? null : storeDtoBuilder.build();
    }


    /* START - getter */

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }

    public List<Local_Product> getLocalProducts() {
        return localProducts;
    }

    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Contact getManager() {
        return manager;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(Contact manager) {
        this.manager = manager;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLocalProducts(List<Local_Product> localProducts) {
        this.localProducts = localProducts;
    }

    public void setOpeningHours(List<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    /* END - setter */
}

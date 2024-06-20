package com.knausrr.Knausrr.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Entity
public class Store {
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

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    @JsonIgnore
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    @JsonIgnore
    private List<Local_Product> localProducts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    @JsonIgnore
    private List<OpeningHours> openingHours;

    /**
     * accepted currencies (CH -> CHF/EUR)
     */
    private List<Currency> currencies;

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
    /* END - getter */

    /* START - setter */
    /* END - setter */
}

package com.knausrr.Knausrr.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.knausrr.Knausrr.entities.dtos.*;
import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.*;

@Entity
@NamedNativeQueries(
    {
        @NamedNativeQuery(name = "findByCompanyName",
                query = "select s.* from store s inner join company c on c.id = s.company where c.name = ?1"
        ),
        @NamedNativeQuery(name = "findByName",
                query = "select * from store where name = ?1",
                resultClass = Store.class
        )
    }
)
public class Store {
    /* START - members */
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    @Column(name = "store_id")
    private UUID id;

    @Column(name = "store_name", nullable = false, unique = true)
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
    public Store(StoreDTO s) {
        this.id = s.getId();
        this.name = s.getName();
        this.currencies = s.getCurrencies();
        this.manager = new Contact(s.getManager());
        this.address = new Address(s.getAddress());
        this.company = new Company(s.getCompany());
        this.localProducts = s.getLocalProducts().stream().map(p -> new Local_Product(p)).toList();
        this.openingHours = s.getOpeningHours().stream().map(o -> new OpeningHours(o)).toList();
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
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store))
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
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store))
                    .with((storedto, empty) -> {
                        storedto.setAddress(store.getAddress(), exLvl);
                    }, null)
                    .with((storedto, empty) -> {
                        storedto.setCompany(store.getCompany(), exLvl);
                    }, null);
            case MINIMAL:
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store))
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
                storeDtoBuilder = DTOBuilder.of(() -> new StoreDTO(store))
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

    public UUID getId() {
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

    public void setId(UUID id) {
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

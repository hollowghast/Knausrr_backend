package com.knausrr.Knausrr.entities;


import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.PersistenceCreator;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
public class Local_Product{
    /* START - members */
    @Id
    @SequenceGenerator(
            name = "seq_Local_Product",
            sequenceName = "seq_Local_Product",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Local_Product"
    )
    @Column(name = "local_product_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    private Timestamp _created;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    private Timestamp _last_change;

    private Double price;
    private Double pricePerUnit;
    private Double unitSize;
    @Enumerated(EnumType.ORDINAL)
    private ProductUnit unit; //->enum
    private Integer unitCount;
    private Blob image;

    /* END - members */

    /* START - references */
    @ManyToOne
    @JoinColumn(name = "base_product_id", nullable = false)
    private Base_Product base_product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false) //done
    private Store store;

    @OneToMany(mappedBy = "local_product")
    private List<Price> prices;
    /* END - references */

    /* START - constructors */
    @PersistenceCreator
    public Local_Product(Base_Product base_product, Store store) {
        this.base_product = base_product;
        this.store = store;
    }
    /* END - constructors */

    /* START - GETTER */
    public Store getStore() {
        return store;
    }
    public Long getId() {
        return id;
    }
    public List<Price> getPrices(LocalDate from, LocalDate until) {
        return prices;
    }
    public Base_Product getBase_product() {
        return base_product;
    }
    public Double getPrice() {
        return price;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public Double getUnitSize() {
        return unitSize;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public Blob getImage() {
        return image;
    }
    /* END - GETTER */

    /* START - SETTER */
    public void setStore(Store store) {
        this.store = store;
    }

    private void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setUnitSize(Double unitSize) {
        this.unitSize = unitSize;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    /* END - SETTER */


    /* START - modifying */
    public void addPrice(Price price) {
        this.prices.add(price);
    }
    public void adjustPrice(Double price) {
        this.price = price;
    }
    /* END - modifying */
}

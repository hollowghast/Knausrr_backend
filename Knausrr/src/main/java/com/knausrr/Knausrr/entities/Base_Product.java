package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Query;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.UUID;

@Entity
/*
@NamedQueries(
        @NamedQuery(name = "Base_Product.findBaseProductsById",
                query="SELECT b.* FROM Base_Product b WHERE b.id=?1"
        )
)
*/
@NamedNativeQueries(
        @NamedNativeQuery(name = "Base_Product.findBaseProductsById",
            query = "SELECT b.* FROM Base_Product b WHERE b.id = ?", resultClass = Base_Product.class)
)
public class Base_Product {
    /* START - members */
    @Id
    /*
    @SequenceGenerator(
            name = "seq_Base_Product",
            sequenceName = "seq_Base_Product",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Base_Product"
    )
    private Long id;
    */
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String barcode; //pk?
    @Column(name = "base_product_name", nullable = false)
    private String name;
    private String description;
    @CreationTimestamp
    private Timestamp _creation;
    @CreationTimestamp
    private Timestamp _last_update;
    /* END - members */

    /* START - references */
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    /* END - references */

    /* START - constructors */
    public Base_Product(String barcode, String name, String description, Brand brand) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.brand = brand;
    }

    public Base_Product() {
    }
    /* END - constructors */

    /* START - getter */
    public UUID getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Brand getBrand() {
        return brand;
    }

    public Timestamp get_creation() {
        return _creation;
    }

    public Timestamp get_last_update() {
        return _last_update;
    }
    /* END - getter */

    /* START - setter */

    public void setId(UUID id) {
        this.id = id;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void set_creation(Timestamp _creation) {
        this._creation = _creation;
    }

    public void set_last_update(Timestamp _last_update) {
        this._last_update = _last_update;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    /* END - setter */
}

package com.knausrr.Knausrr.entities;

import lombok.*;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Currency;

@Entity
@Data
@NamedQueries(
        @NamedQuery(name = "Base_Product.findBaseProductsById",
                query="SELECT b FROM Base_Product b WHERE b.id=:id"
        )
)
public class Base_Product {
    @Id
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
    @Column(nullable = false)
    private final String barcode; //pk?
    @Column(name = "base_product_name", nullable = false)
    private final String name;
    private final String description;
    private Timestamp _last_update;


    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private final Brand brand;

    public Base_Product(String barcode, String name, String description, Brand brand) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.brand = brand;
    }

    /* START - getter */
    public Long getId() {
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
    /* END - getter */

    /* START - setter */

    /* END - setter */
}

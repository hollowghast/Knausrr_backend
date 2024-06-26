package com.knausrr.Knausrr.entities;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Data
public class Price {
    @Id
    @SequenceGenerator(
            name = "seq_Price",
            sequenceName = "seq_Price",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Price"
    )
    @Column(name = "price_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "local_product_id", nullable = false)
    private Local_Product local_product;
    @Column(nullable = false)
    private Float price;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime start_date;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime end_date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Price_Type type;

    public Price(Local_Product local_product, Float price, OffsetDateTime start_date, Price_Type type) {
        this.local_product = local_product;
        this.price = price;
        this.start_date = start_date;
        this.type = type;
    }
}

package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity

public class Price {
    /* START - members */
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

    @Column(nullable = false)
    private Double price;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime start_date;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime end_date;
    /* END - members */

    /* START - references */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Price_Type type;

    @ManyToOne
    @JoinColumn(name = "local_product_id", nullable = false)
    private Local_Product local_product;
    /* END - references */

    /* START - constructors */
    public Price(Local_Product local_product, Double price, OffsetDateTime start_date, Price_Type type) {
        this.local_product = local_product;
        this.price = price;
        this.start_date = start_date;
        this.type = type;
    }

    public Price() {
    }
    /* END - constructors */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public OffsetDateTime getStart_date() {
        return start_date;
    }

    public OffsetDateTime getEnd_date() {
        return end_date;
    }

    public Price_Type getType() {
        return type;
    }

    public Local_Product getLocal_product() {
        return local_product;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStart_date(OffsetDateTime start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(OffsetDateTime end_date) {
        this.end_date = end_date;
    }

    public void setType(Price_Type type) {
        this.type = type;
    }

    public void setLocal_product(Local_Product local_product) {
        this.local_product = local_product;
    }
    /* END - setter */
}

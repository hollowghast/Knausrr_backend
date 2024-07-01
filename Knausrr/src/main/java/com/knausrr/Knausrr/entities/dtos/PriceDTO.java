package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.entities.Price;
import com.knausrr.Knausrr.entities.Price_Type;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

public class PriceDTO {
    /* START - members */
    private Long id;
    private Double price;
    private OffsetDateTime start_date;
    private OffsetDateTime end_date;
    private Price_Type type;
    /* END - members */

    /* START - references */
    private LocalProductDTO local_product;
    /* END - references */

    /* START - constructors */

    public PriceDTO() {
    }

    public PriceDTO(Price p, ExposureLevel exLvl) {
        this.id = p.getId();
        this.price = p.getPrice();
        this.start_date = p.getStart_date();
        this.end_date = p.getEnd_date();
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

    public LocalProductDTO getLocal_product() {
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

    public void setLocal_product(Local_Product lp, ExposureLevel exLvl) {

    }
    /* END - setter */
}

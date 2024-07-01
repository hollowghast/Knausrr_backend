package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

public class BaseProductDTO {
    /* START - members */
    private UUID id;
    private String barcode; //pk?
    private String name;
    private String description;
    private Timestamp _creation;
    private Timestamp _last_update;
    /* END - members */

    /* START - references */
    private BrandDTO brand;
    /* END - references */

    /* START - constructors */

    public BaseProductDTO() {
    }

    public BaseProductDTO(Base_Product bp, ExposureLevel exLvl) {
        this.id = bp.getId();
        this.barcode = bp.getBarcode();
        this.name = bp.getName();
        this.description = bp.getDescription();
        this._creation = bp.get_creation();
        this._last_update = bp.get_last_update();
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

    public Timestamp get_creation() {
        return _creation;
    }

    public Timestamp get_last_update() {
        return _last_update;
    }

    public BrandDTO getBrand() {
        return brand;
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

    public void setBrand(Brand brand, ExposureLevel exLvl) {

    }
    /* END - setter */
}

package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

public class LocalProductDTO {
    /* START - members */
    private Long id;
    private Timestamp _created;
    private Timestamp _last_change;
    private Double price;
    private Double pricePerUnit;
    private Double unitSize;
    private ProductUnit unit; //->enum
    private Integer unitCount;
    private Blob image;
    /* END - members */

    /* START - references */
    private BaseProductDTO base_product;
    private StoreDTO store;
    private List<PriceDTO> prices;
    /* END - references */

    /* START - constructors */

    public LocalProductDTO() {
    }

    public LocalProductDTO(Local_Product lp, ExposureLevel exLvl) {
        this.id=lp.getId();
        this._created = lp.get_created();
        this._last_change = lp.get_last_change();
        this.price = lp.getPrice();
        this.pricePerUnit = lp.getPricePerUnit();
        this.unitSize = lp.getUnitSize();
        this.unitCount = lp.getUnitCount();
        this.image = lp.getImage();
    }
    /* END - constructors */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public Timestamp get_created() {
        return _created;
    }

    public Timestamp get_last_change() {
        return _last_change;
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

    public BaseProductDTO getBase_product() {
        return base_product;
    }

    public StoreDTO getStore() {
        return store;
    }

    public List<PriceDTO> getPrices() {
        return prices;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void set_created(Timestamp _created) {
        this._created = _created;
    }

    public void set_last_change(Timestamp _last_change) {
        this._last_change = _last_change;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setUnitSize(Double unitSize) {
        this.unitSize = unitSize;
    }

    public void setUnit(ProductUnit unit) {
        this.unit = unit;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public void setBase_product(Base_Product bp, ExposureLevel exLvl) {

    }

    public void setStore(Store store, ExposureLevel exLvl) {

    }

    public void setPrices(List<Price> prices, ExposureLevel exLvl) {

    }
    /* END - setter */
}

package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.knausrr.Knausrr.entities.dtos.BaseProductDTO;
import com.knausrr.Knausrr.entities.dtos.BrandDTO;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Query;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

@Entity
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
    public Base_Product(BaseProductDTO bp) {
        this.id = bp.getId();
        this.barcode = bp.getBarcode();
        this.name = bp.getName();
        this.description = bp.getDescription();
        this._creation = bp.get_creation();
        this._last_update = bp.get_last_update();

        this.brand = new Brand(bp.getBrand());
    }

    public Base_Product() {
    }
    /* END - constructors */

    public final static BaseProductDTO buildDto(Base_Product bp, ExposureLevel exLvl){
        DTOBuilder<BaseProductDTO> bpDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                bpDtoBuilder = DTOBuilder.of(() -> new BaseProductDTO(bp, exLvl));
            }
        }

        return Objects.isNull(bpDtoBuilder) ? null : bpDtoBuilder.build();
    }

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

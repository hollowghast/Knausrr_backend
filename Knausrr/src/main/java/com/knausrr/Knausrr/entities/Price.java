package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.LocalProductDTO;
import com.knausrr.Knausrr.entities.dtos.PriceDTO;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@NamedNativeQueries({

})
public class Price {
    /* START - members */
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    @Column(name = "price_id")
    private UUID id;

    @Column(nullable = false)
    private Double price;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime start_date;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime end_date;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Price_Type type;
    /* END - members */

    /* START - references */
    @ManyToOne
    @JoinColumn(name = "local_product_id", nullable = false)
    private Local_Product local_product;
    /* END - references */

    /* START - constructors */
    public Price(PriceDTO p) {
        this.price = p.getPrice();
        this.start_date = p.getStart_date();
        this.end_date = p.getEnd_date();

        this.type = p.getType();
        this.local_product = new Local_Product(p.getLocal_product());
    }

    public Price() {
    }
    /* END - constructors */

    public final static PriceDTO buildDto(Price p, ExposureLevel exLvl){
        DTOBuilder<PriceDTO> pDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                pDtoBuilder = DTOBuilder.of(() -> new PriceDTO(p));
            }
        }

        return Objects.isNull(pDtoBuilder) ? null : pDtoBuilder.build();
    }

    /* START - getter */

    public UUID getId() {
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

    public void setId(UUID id) {
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

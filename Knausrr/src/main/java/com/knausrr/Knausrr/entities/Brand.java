package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.knausrr.Knausrr.entities.dtos.BrandDTO;
import com.knausrr.Knausrr.entities.dtos.CompanyDTO;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@NamedNativeQueries({

})
public class Brand {
    /* START - members */
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    @Column(name = "brand_id")
    private UUID id;
    @Column(name = "brand_name", nullable = false, unique = true)
    private String name;
    /* END - members */

    /* START - references */
    @OneToMany(mappedBy = "brand")
    private List<Base_Product> base_products;
    /* END - references */

    /* START - constructors */
    public Brand(BrandDTO brand) {
        this.id = brand.getId();
        this.name = brand.getName();

        this.base_products = brand.getBase_products().stream().map(bp -> new Base_Product(bp)).toList();
    }

    public Brand() {
    }
    /* END - constructors */

    public final static BrandDTO buildDto(Brand brand, ExposureLevel exLvl){
        DTOBuilder<BrandDTO> brandDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                brandDtoBuilder = DTOBuilder.of(() -> new BrandDTO(brand));
            }
        }

        return Objects.isNull(brandDtoBuilder) ? null : brandDtoBuilder.build();
    }

    /* START - getter */
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Base_Product> getBase_products() {
        return base_products;
    }
    /* END - getter */

    /* START - setter */

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBase_products(List<Base_Product> base_products) {
        this.base_products = base_products;
    }
    /* END - setter */
}

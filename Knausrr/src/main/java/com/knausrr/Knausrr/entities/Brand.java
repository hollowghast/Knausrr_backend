package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity

public class Brand {
    @Id
    @SequenceGenerator(
            name = "seq_Brand",
            sequenceName = "seq_Brand",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Brand"
    )
    @Column(name = "brand_id")
    private Long id;
    @Column(name = "brand_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Base_Product> base_products;

    /* START - constructors */
    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }
    /* END - constructors */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Base_Product> getBase_products() {
        return base_products;
    }
}

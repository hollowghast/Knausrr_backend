package com.knausrr.Knausrr.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
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
    private List<Base_Product> base_products;

    public Brand(String name) {
        this.name = name;
    }

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

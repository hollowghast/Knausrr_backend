package com.knausrr.Knausrr.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class Company {
    @SequenceGenerator(name="seq_Company",
            sequenceName = "seq_Company")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "seq_Company")
    @Column(name = "company_id")
    private Long id;

    @OneToMany(mappedBy = "company",
    cascade = CascadeType.ALL) //done
    private List<Store> stores;

    @Column(name = "company_name", nullable = false)
    private String name;

    @Lob
    private byte [] logo;

    public Company(String name) {
        this.name = name;
    }
}

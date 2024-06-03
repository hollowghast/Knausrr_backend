package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity

public class Company {
    @SequenceGenerator(name="seq_Company",
            sequenceName = "seq_Company")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "seq_Company")
    @Column(name = "company_id")
    private Long id;

    @OneToMany(mappedBy = "company",
    cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Store> stores;

    @Column(name = "company_name", nullable = false)
    private String name;

    @Lob
    private byte [] logo;

    /* START - constructors */
    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }
    /* END - constructors */
}

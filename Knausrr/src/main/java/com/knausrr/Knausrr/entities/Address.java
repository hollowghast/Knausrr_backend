package com.knausrr.Knausrr.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @SequenceGenerator(
            name = "seq_Address",
            sequenceName = "seq_Address",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Address"
    )
    @Column(name = "address_id")
    private Long id;
    private String country;
    private String district;
    @Column(nullable = false)
    private String zipcode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    private String details;

    @OneToOne(mappedBy = "address") //done
    private Store store;

    public Address(String zipcode, String city, String street) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
    }
}

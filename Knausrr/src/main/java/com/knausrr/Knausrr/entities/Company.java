package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.knausrr.Knausrr.entities.dtos.AddressDTO;
import com.knausrr.Knausrr.entities.dtos.CompanyDTO;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public final static CompanyDTO buildDto(Company company, ExposureLevel exLvl){
        DTOBuilder<CompanyDTO> companyDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                companyDtoBuilder = DTOBuilder.of(() -> new CompanyDTO(company, exLvl));
            }
        }

        return Objects.isNull(companyDtoBuilder) ? null : companyDtoBuilder.build();
    }

    /* START - getter */

    public Long getId() {
        return id;
    }

    public List<Store> getStores() {
        return stores;
    }

    public String getName() {
        return name;
    }

    public byte[] getLogo() {
        return logo;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    /* END - setter */
}

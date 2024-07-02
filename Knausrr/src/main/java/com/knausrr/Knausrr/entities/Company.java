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
import java.util.UUID;

@Entity
@NamedNativeQueries({

})
public class Company {
    /* START - members */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id")
    private UUID id;
    @Column(name = "company_name", nullable = false)
    private String name;
    @Lob
    private byte [] logo;
    /* END - members */

    /* START - references */
    @OneToMany(mappedBy = "company",
    cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Store> stores;
    /* END - references */

    /* START - constructors */
    public Company(CompanyDTO comp)
    {
        this.id = comp.getId();
        this.name = comp.getName();
        this.logo = comp.getLogo();

        this.stores = comp.getStores().stream().map(s -> new Store(s)).toList();
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
                companyDtoBuilder = DTOBuilder.of(() -> new CompanyDTO(company));
            }
        }

        return Objects.isNull(companyDtoBuilder) ? null : companyDtoBuilder.build();
    }

    /* START - getter */

    public UUID getId() {
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

    public void setId(UUID id) {
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

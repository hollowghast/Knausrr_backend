package com.knausrr.Knausrr.entities;

import com.knausrr.Knausrr.entities.dtos.ContactDTO;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.LocalProductDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ValueGenerationType;

import java.util.Objects;
import java.util.UUID;

@Entity
@NamedNativeQueries({

})
public class Contact {
    /* START - members */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "contact_id")
    private UUID id;

    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private String email;
    private String phoneNumber;
    /* END - members */

    /* START - references */
    /* END - references */

    /* START - constructors */

    public Contact(ContactDTO c) {
        this.id = c.getId();
        this.firstname = c.getFirstname();
        this.lastname = c.getLastname();
        this.email = c.getEmail();
        this.phoneNumber = c.getPhoneNumber();
    }

    public Contact() {
    }
    /* END - constructors */

    public final static ContactDTO buildDto(Contact c, ExposureLevel exLvl){
        DTOBuilder<ContactDTO> cDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                cDtoBuilder = DTOBuilder.of(() -> new ContactDTO(c));
            }
        }

        return Objects.isNull(cDtoBuilder) ? null : cDtoBuilder.build();
    }


    /* START - getter */

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    /* END - getter */

    /* START - setter */

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = isValidEmail(email) ? email : null;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /* END - setter */

    private boolean isValidEmail(String email){
        return true;
    }


}

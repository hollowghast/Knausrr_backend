package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.Contact;
import jakarta.persistence.*;

import java.util.UUID;

public class ContactDTO {
    /* START - members */
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    /* END - members */

    /* START - references */
    /* END - references */

    /* START - constructors */

    public ContactDTO(Contact c) {
        this.id = c.getId();
        this.firstname = c.getFirstname();
        this.lastname = c.getLastname();
        this.email = c.getEmail();
        this.phoneNumber = c.getPhoneNumber();
    }

    public ContactDTO() {
    }
    /* END - constructors */

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
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /* END - getter */

}

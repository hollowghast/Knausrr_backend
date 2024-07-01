package com.knausrr.Knausrr.entities.dtos;

import com.knausrr.Knausrr.entities.OpeningHours;
import com.knausrr.Knausrr.entities.Store;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class OpeningHoursDTO {
    /* START - members */
    private Long id;
    private Integer startTime;
    private Integer endTime;
    private Date specialOpeningHours;
    /* END - members */

    /* START - references */
    private StoreDTO store;
    /* END - references */

    /* START - constructors */

    public OpeningHoursDTO() {
    }

    public OpeningHoursDTO(OpeningHours oh, ExposureLevel exLvl) {
        this.id = oh.getId();
        this.startTime = oh.getStartTime();
        this.endTime = oh.getEndTime();
        this.specialOpeningHours = oh.getSpecialOpeningHours();
    }
    /* END - constructors */

    /* START - getter */

    public Long getId() {
        return id;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public Date getSpecialOpeningHours() {
        return specialOpeningHours;
    }

    public StoreDTO getStore() {
        return store;
    }
    /* END - getter */

    /* START - setter */

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public void setSpecialOpeningHours(Date specialOpeningHours) {
        this.specialOpeningHours = specialOpeningHours;
    }

    public void setStore(Store store, ExposureLevel exLvl) {

    }
    /* END - setter */
}

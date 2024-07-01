package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.knausrr.Knausrr.entities.dtos.DTOBuilder;
import com.knausrr.Knausrr.entities.dtos.ExposureLevel;
import com.knausrr.Knausrr.entities.dtos.LocalProductDTO;
import com.knausrr.Knausrr.entities.dtos.OpeningHoursDTO;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity

public class OpeningHours {
    /* START - members */
    @Id
    @SequenceGenerator(
            name = "seq_Opening_Hours",
            sequenceName = "seq_Opening_Hours",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Opening_Hours"
    )
    @Column(name = "opening_hours_id")
    private Long id;

    /**
     * Format 0800 - 1200
     * always assuming the local time zone
     */
    @Column(nullable = false)
    private Integer startTime;
    @Column(nullable = false)
    private Integer endTime;

    private Date specialOpeningHours;
    /* END - members */

    /* START - references */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    /* END - references */

    /* START - constructors */
    /**
     * Sets general opening hours which are valid for EVERY day
     * @param store
     * @param start_time
     * @param end_time
     */
    public OpeningHours(Long id, Store store, Integer start_time, Integer end_time) {
        this.id=id;
        this.store = store;
        this.startTime = start_time;
        this.endTime = end_time;
    }

    /**
     * Sets opening hours on this specific date
     * @param store
     * @param start_time
     * @param end_time
     * @param date
     */
    public OpeningHours(Long id, Store store, Integer start_time, Integer end_time, Date date) {
        this.id=id;
        this.store = store;
        this.startTime = start_time;
        this.endTime = end_time;
        this.specialOpeningHours = date;
    }

    public OpeningHours() {
    }
    /* END - constructors */

    public final static OpeningHoursDTO buildDto(OpeningHours oh, ExposureLevel exLvl){
        DTOBuilder<OpeningHoursDTO> ohDtoBuilder = null;

        switch (exLvl){
            case EXTENDED:
            case COMPLETE:
            case FAST:
            case MINIMAL:
            case STANDARD :
            default: {
                ohDtoBuilder = DTOBuilder.of(() -> new OpeningHoursDTO(oh, exLvl));
            }
        }

        return Objects.isNull(ohDtoBuilder) ? null : ohDtoBuilder.build();
    }

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

    public Store getStore() {
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

    public void setStore(Store store) {
        this.store = store;
    }
    /* END - setter */
}

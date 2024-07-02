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
import java.util.UUID;

@Entity
@NamedNativeQueries({

})
public class OpeningHours {
    /* START - members */
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    @Column(name = "opening_hours_id")
    private UUID id;

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
    public OpeningHours(OpeningHoursDTO oh) {
        this.id = oh.getId();
        this.startTime = oh.getStartTime();
        this.endTime = oh.getEndTime();
        this.specialOpeningHours = oh.getSpecialOpeningHours();

        this.store = new Store(oh.getStore());
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
                ohDtoBuilder = DTOBuilder.of(() -> new OpeningHoursDTO(oh));
            }
        }

        return Objects.isNull(ohDtoBuilder) ? null : ohDtoBuilder.build();
    }

    /* START - getter */

    public UUID getId() {
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

    public void setId(UUID id) {
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

package com.knausrr.Knausrr.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Entity

public class OpeningHours {
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
    private Double startTime;
    @Column(nullable = false)
    private Double endTime;

    private Date specialOpeningHours;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    @JsonIgnore
    private Store store;



    /**
     * Sets general opening hours which are valid for EVERY day
     * @param store
     * @param start_time
     * @param end_time
     */
    public OpeningHours(Long id, Store store, Double start_time, Double end_time) {
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
    public OpeningHours(Long id, Store store, Double start_time, Double end_time, Date date) {
        this.id=id;
        this.store = store;
        this.startTime = start_time;
        this.endTime = end_time;
        this.specialOpeningHours = date;
    }

    public OpeningHours() {
    }
}

package com.knausrr.Knausrr.entities;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Data
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
    private final Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false) //done
    private Store store;

    /**
     * Format 0800 - 1200
     * always assuming the local time zone
     */
    @Column(nullable = false)
    private final Double startTime;
    @Column(nullable = false)
    private final Double endTime;

    private Date specialOpeningHours;

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
}

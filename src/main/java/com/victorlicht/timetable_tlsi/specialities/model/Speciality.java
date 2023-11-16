package com.victorlicht.timetable_tlsi.specialities.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.ComponentScan;

@Getter
@Setter
@Accessors(chain = true)
@ComponentScan
@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Major major;

    @Column(nullable = false)
    private String specialityName;

    @Column(length = 8, unique = true, nullable = false)
    private String specialityCode;

    @Column(columnDefinition = "TEXT")
    private String description;
}

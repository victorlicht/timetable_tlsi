package com.victorlicht.timetable_tlsi.speciality.model;

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

    @Column(length = 8)
    private String major;

    @Column(length = 8)
    private String specialityName;

    @Column(length = 8, unique = true)
    private String specialityCode;

}

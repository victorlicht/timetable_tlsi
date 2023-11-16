package com.victorlicht.timetable_tlsi.courses.model;

import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@ComponentScan
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(length = 6, nullable = false)
    private String courseCode;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Speciality speciality;


    @ManyToMany
    private Set<Professor> professors = new HashSet<>();

    @Column(nullable = false)
    private int coefficient;

    @Column(nullable = false)
    private int credit;

    @Column(columnDefinition = "TEXT")
    private String description;

}

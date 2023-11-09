package com.victorlicht.timetable_tlsi.course.model;

import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.speciality.model.Speciality;
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
    private int id;

    @Column
    private String courseName;

    @Column(length = 6)
    private String courseCode;

    @ManyToOne
    private Speciality speciality;


    @ManyToMany
    private Set<Professor> professors = new HashSet<>();

    @Column
    private int coefficient;

    @Column
    private int credit;

}

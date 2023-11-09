package com.victorlicht.timetable_tlsi.accounts.models;

import com.victorlicht.timetable_tlsi.course.model.Course;
import com.victorlicht.timetable_tlsi.group.model.StudentGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @OneToOne
    private AccountUser accountUser;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(columnDefinition = "YEAR")
    private int yearOfTeaching;

    @ManyToMany(mappedBy = "professors")
    private Set<StudentGroup> studentGroups = new HashSet<>();

    @ManyToMany(mappedBy = "professors")
    private Set<Course> courses = new HashSet<>();
}

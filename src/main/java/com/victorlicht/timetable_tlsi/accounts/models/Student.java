package com.victorlicht.timetable_tlsi.accounts.models;

import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(unique = true, nullable = false)
    private AccountUser accountUser;

    @ManyToOne
    @JoinColumn(nullable = false)
    private StudentGroup studentGroup;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Speciality speciality;

    @Column(columnDefinition = "YEAR")
    private int yearOfStudy;
}

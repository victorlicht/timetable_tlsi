package com.victorlicht.timetable_tlsi.accounts.models;

import com.victorlicht.timetable_tlsi.group.model.StudentGroup;
import com.victorlicht.timetable_tlsi.speciality.model.Speciality;
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
    @Column(length = 36)
    private String id;

    @OneToOne
    private AccountUser accountUser;

    @ManyToOne
    private StudentGroup studentGroup;

    @ManyToOne
    private Speciality speciality;

    @Column(columnDefinition = "YEAR")
    private int yearOfStudy;
}

package com.victorlicht.timetable_tlsi.sessions.model;

import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.classrooms.model.Classroom;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
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
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Enumerated(EnumType.STRING)
    private SessionDate sessionDate;

    @Enumerated(EnumType.STRING)
    private SessionTime sessionTime;

    @Enumerated(EnumType.STRING)
    private SessionType sessionType;

    @ManyToOne
    private Classroom classroom;

    @ManyToOne
    private StudentGroup group;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Speciality speciality;

}

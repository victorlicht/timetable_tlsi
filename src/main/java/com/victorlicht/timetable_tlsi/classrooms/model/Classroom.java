package com.victorlicht.timetable_tlsi.classrooms.model;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"classroomNumber", "classroomType"}))
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Enumerated
    private ClassroomType classroomType;

    @Column
    private int classroomNumber;
}

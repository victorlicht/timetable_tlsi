package com.victorlicht.timetable_tlsi.classroom.model;

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
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Enumerated
    private ClassroomType classroomType;

    @Column
    private int classroomNumber;

    @Column
    private boolean isAvailable;
}

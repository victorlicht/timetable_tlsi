package com.victorlicht.timetable_tlsi.groups.model;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"speciality", "groupCode"}))
@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String groupCode;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Speciality speciality;

    @ManyToMany
    private Set<Professor> professors = new HashSet<>();

}

package com.victorlicht.timetable_tlsi.courses.dto;

import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDto {

    private String courseName;

    private String courseCode;

    private Speciality speciality;

    private Set<Professor> professors = new HashSet<>();

    private int coefficient;

    private int credit;

    private String description;
}

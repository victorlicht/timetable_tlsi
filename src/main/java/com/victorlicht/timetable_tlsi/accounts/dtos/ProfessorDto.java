package com.victorlicht.timetable_tlsi.accounts.dtos;

import com.victorlicht.timetable_tlsi.accounts.models.Grade;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;

import java.util.HashSet;
import java.util.Set;

public class ProfessorDto {
    private Grade grade;

    private int yearOfTeaching;

    private boolean isAdmin;

    private Set<StudentGroup> studentGroups = new HashSet<>();

    private Set<Course> courses = new HashSet<>();
}

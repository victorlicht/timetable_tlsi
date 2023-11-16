package com.victorlicht.timetable_tlsi.accounts.dtos;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Grade;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProfessorDto {
    private AccountUser accountUser;

    private Grade grade;

    private int yearOfTeaching;

    private boolean isAdmin;

    private Set<StudentGroup> studentGroups = new HashSet<>();

    private Set<Course> courses = new HashSet<>();
}

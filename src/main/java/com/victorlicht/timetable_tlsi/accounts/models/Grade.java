package com.victorlicht.timetable_tlsi.accounts.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    TEACHER_A("Teacher A"),
    TEACHER_B("Teacher B"),
    TEACHER_C("Teacher C"),
    TEACHER_D("Teacher D"),
    PROFESSOR_A("Professor A"),
    PROFESSOR_B("Professor B"),
    PROFESSOR_C("Professor C"),
    PROFESSOR_D("Professor D"),
    DEPARTMENT_LEADER("Department Leader"),
    VICE_DEPARTMENT("Vice Department");
    private final String title;
}

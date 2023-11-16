package com.victorlicht.timetable_tlsi.groups.dto;

import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class StudentGroupDto {

    private Speciality speciality;

    private Set<Professor> professors = new HashSet<>();

}

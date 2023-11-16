package com.victorlicht.timetable_tlsi.accounts.dtos;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import lombok.Data;

@Data
public class StudentDto {

    private AccountUser accountUser;

    private StudentGroup studentGroup;

    private Speciality speciality;

    private int yearOfStudy;
}

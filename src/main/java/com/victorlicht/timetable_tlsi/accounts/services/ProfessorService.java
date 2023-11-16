package com.victorlicht.timetable_tlsi.accounts.services;

import com.victorlicht.timetable_tlsi.accounts.dtos.ProfessorDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Grade;
import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface ProfessorService {
    ProfessorDto createProfessorAccountUser(ProfessorDto professorDto);
    ProfessorDto updateProfessorAccount(ProfessorDto professorDto, Professor professor);
    Page<ProfessorDto> findProfessorsDynamically(
            AccountUser accountUser,
            Set<Course> courses,
            Set<StudentGroup> studentGroups,
            Grade grade,
            boolean isAdmin,
            int yearOfTeaching,
            String orderByField,
            String sortOrder,
            Pageable pageable
    );
}
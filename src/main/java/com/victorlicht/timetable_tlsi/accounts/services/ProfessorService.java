package com.victorlicht.timetable_tlsi.accounts.services;

import com.victorlicht.timetable_tlsi.accounts.dtos.ProfessorDto;
import com.victorlicht.timetable_tlsi.accounts.models.Professor;

public interface ProfessorService {
    ProfessorDto createProfessorAccountUser(ProfessorDto professorDto);
    ProfessorDto updateProfessorAccount(ProfessorDto professorDto, Professor professor);
}
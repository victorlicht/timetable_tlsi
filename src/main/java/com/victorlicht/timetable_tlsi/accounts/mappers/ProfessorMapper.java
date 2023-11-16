package com.victorlicht.timetable_tlsi.accounts.mappers;

import com.victorlicht.timetable_tlsi.accounts.dtos.ProfessorDto;
import com.victorlicht.timetable_tlsi.accounts.models.Professor;

public class ProfessorMapper {

    public static ProfessorDto toDto(Professor professor) {
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setAccountUser(professor.getAccountUser());
        professorDto.setGrade(professor.getGrade());
        professorDto.setYearOfTeaching(professor.getYearOfTeaching());
        professorDto.setAdmin(professor.isAdmin());
        professorDto.setStudentGroups(professor.getStudentGroups());
        professorDto.setCourses(professor.getCourses());
        
        return professorDto;
    }
    
    public static  Professor toEntity(ProfessorDto professorDto) {
        Professor professor = new Professor();
        professor.setAccountUser(professorDto.getAccountUser());
        professor.setGrade(professorDto.getGrade());
        professor.setYearOfTeaching(professorDto.getYearOfTeaching());
        professor.setAdmin(professorDto.isAdmin());
        professor.setStudentGroups(professorDto.getStudentGroups());
        professor.setCourses(professorDto.getCourses());
        
        return professor;
    }

    public static void updateEntityFromDto(ProfessorDto professorDto, Professor professor) {
        if (professorDto.getAccountUser() != null) {
            professor.setAccountUser(professorDto.getAccountUser());
        }
        if (professorDto.getGrade() != null) {
            professor.setGrade(professorDto.getGrade());
        }
        if (professorDto.getYearOfTeaching() > 0) {
            professor.setYearOfTeaching(professorDto.getYearOfTeaching());
        }else {
            professor.setYearOfTeaching(1111);
        }
        if (professorDto.isAdmin()) {
            professor.setAdmin(true);
        }
        if (professorDto.getCourses() != null) {
            professor.setCourses(professorDto.getCourses());
        }
        if (professorDto.getStudentGroups() != null) {
            professor.setStudentGroups(professorDto.getStudentGroups());
        }
    }
}

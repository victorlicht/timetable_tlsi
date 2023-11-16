package com.victorlicht.timetable_tlsi.accounts.mappers;

import com.victorlicht.timetable_tlsi.accounts.dtos.StudentDto;
import com.victorlicht.timetable_tlsi.accounts.models.Student;

public class StudentMapper {
    public static StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setAccountUser(student.getAccountUser());
        studentDto.setStudentGroup(student.getStudentGroup());
        studentDto.setSpeciality(student.getSpeciality());
        studentDto.setYearOfStudy(student.getYearOfStudy());
        return studentDto;
    }

    public static Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setAccountUser(studentDto.getAccountUser());
        student.setStudentGroup(studentDto.getStudentGroup());
        student.setSpeciality(studentDto.getSpeciality());
        student.setYearOfStudy(studentDto.getYearOfStudy());
        return student;
    }

    public static void updateEntityFromDto(StudentDto studentDto, Student student) {
        if (studentDto.getAccountUser() != null) {
            student.setAccountUser(studentDto.getAccountUser());
        }
        if (studentDto.getStudentGroup() != null) {
            student.setStudentGroup(studentDto.getStudentGroup());
        }
        if (studentDto.getSpeciality() != null) {
            student.setSpeciality(studentDto.getSpeciality());
        }
        if (studentDto.getYearOfStudy() > 0) {
            student.setYearOfStudy(studentDto.getYearOfStudy());
        }
    }
}

package com.victorlicht.timetable_tlsi.classrooms.service;

import com.victorlicht.timetable_tlsi.classrooms.dto.ClassroomDto;
import com.victorlicht.timetable_tlsi.classrooms.model.ClassroomType;

import java.util.List;

public interface ClassroomService {
    ClassroomDto createClassroom(ClassroomDto classroomDto);

    void deleteClassroomByClassroomNumberAndClassroomType(int classroomNumber, ClassroomType classroomType);

    List<ClassroomDto> findByClassroomType(ClassroomType classroomType);

    ClassroomDto findClassroomByClassroomNumber(int classroomNumber);

    List<ClassroomDto> findAll();
}

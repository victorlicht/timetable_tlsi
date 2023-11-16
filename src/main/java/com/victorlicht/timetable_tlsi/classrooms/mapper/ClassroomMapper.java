package com.victorlicht.timetable_tlsi.classrooms.mapper;

import com.victorlicht.timetable_tlsi.classrooms.dto.ClassroomDto;
import com.victorlicht.timetable_tlsi.classrooms.model.Classroom;

import java.util.List;
import java.util.stream.Collectors;

public class ClassroomMapper {
    public static ClassroomDto toDto(Classroom classroom) {
        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setClassroomType(classroom.getClassroomType());
        classroomDto.setClassroomNumber(classroom.getClassroomNumber());
        return classroomDto;
    }

    public static Classroom toEntity(ClassroomDto classroomDto) {
        Classroom classroom = new Classroom();
        classroom.setClassroomType(classroomDto.getClassroomType());
        classroom.setClassroomNumber(classroomDto.getClassroomNumber());
        return classroom;
    }

    public static List<ClassroomDto> toDtoList(List<Classroom> classrooms) {
        return classrooms.stream()
                .map(ClassroomMapper::toDto)
                .collect(Collectors.toList());
    }
}

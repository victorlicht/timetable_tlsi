package com.victorlicht.timetable_tlsi.classrooms.dto;

import com.victorlicht.timetable_tlsi.classrooms.model.ClassroomType;
import lombok.Data;

@Data
public class ClassroomDto {
    private ClassroomType classroomType;
    private int classroomNumber;
}

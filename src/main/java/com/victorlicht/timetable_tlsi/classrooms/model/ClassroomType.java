package com.victorlicht.timetable_tlsi.classrooms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassroomType {
    TD("DIRECTED_STUDY_ROOM"),
    TP("PRACTICAL_ROOM"),
    AMPHI("LECTURE_HALL");

    private final String classRoomType;

}

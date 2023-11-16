package com.victorlicht.timetable_tlsi.classrooms.repository;

import com.victorlicht.timetable_tlsi.classrooms.dto.ClassroomDto;
import com.victorlicht.timetable_tlsi.classrooms.model.Classroom;
import com.victorlicht.timetable_tlsi.classrooms.model.ClassroomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String> {
    void deleteClassroomByClassroomNumberAndClassroomType(int classroomNumber, ClassroomType classroomType);
    List<ClassroomDto> findByClassroomType(ClassroomType classroomType);
    ClassroomDto findClassroomByClassroomNumber(int classroomNumber);
}

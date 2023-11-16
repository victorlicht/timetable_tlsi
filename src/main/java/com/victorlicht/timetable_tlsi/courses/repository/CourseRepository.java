package com.victorlicht.timetable_tlsi.courses.repository;

import com.victorlicht.timetable_tlsi.courses.dto.CourseDto;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    void deleteCourseByCourseCode(String courseCode);
    CourseDto findCourseByCourseCode(String courseCode);
    List<CourseDto> findAllCourses();
    List<CourseDto> findCoursesBySpeciality(Speciality speciality);
}

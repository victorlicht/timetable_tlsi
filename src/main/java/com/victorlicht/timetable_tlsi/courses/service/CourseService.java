package com.victorlicht.timetable_tlsi.courses.service;

import com.victorlicht.timetable_tlsi.courses.dto.CourseDto;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    void deleteCourseById(int courseId);
    CourseDto findCourseById(int courseId);
    List<CourseDto> findAllCourses();
    List<CourseDto> findCoursesBySpeciality(Speciality speciality);
}

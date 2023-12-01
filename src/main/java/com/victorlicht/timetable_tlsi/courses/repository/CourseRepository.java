package com.victorlicht.timetable_tlsi.courses.repository;

import com.victorlicht.timetable_tlsi.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}

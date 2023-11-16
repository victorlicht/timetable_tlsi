package com.victorlicht.timetable_tlsi.groups.repository;

import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

}

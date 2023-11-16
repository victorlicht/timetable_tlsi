package com.victorlicht.timetable_tlsi.accounts.repositories;

import com.victorlicht.timetable_tlsi.accounts.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}

package com.victorlicht.timetable_tlsi.accounts.repositories;

import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
}

package com.victorlicht.timetable_tlsi.accounts.services;

import com.victorlicht.timetable_tlsi.accounts.dtos.ProfessorDto;
import com.victorlicht.timetable_tlsi.accounts.mappers.ProfessorMapper;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Grade;
import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.accounts.repositories.AccountUserRepository;
import com.victorlicht.timetable_tlsi.accounts.repositories.ProfessorRepository;
import com.victorlicht.timetable_tlsi.accounts.repositories.ProfessorSpecifications;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository professorRepository;

    private final AccountUserRepository accountUserRepository;


    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository, AccountUserRepository accountUserRepository) {
        this.professorRepository = professorRepository;
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public Page<ProfessorDto> findProfessorsDynamically(
            AccountUser accountUser,
            Set<Course> courses,
            Set<StudentGroup> studentGroups,
            Grade grade,
            boolean isAdmin,
            int yearOfTeaching,
            String orderByField,
            String sortOrder,
            Pageable pageable
    ) {

        Page<Professor> professorPage = professorRepository.findAll(
                ProfessorSpecifications.filterAndOrder(
                    accountUser, courses, studentGroups, grade,
                    isAdmin, yearOfTeaching, orderByField, sortOrder
                ),
                pageable
        );
        return professorPage.map(ProfessorMapper::toDto);
    }


    @Override
    public ProfessorDto updateProfessorAccount(ProfessorDto professorDto, Professor professor){
        ProfessorMapper.updateEntityFromDto(professorDto, professor);
        return ProfessorMapper.toDto(professorRepository.save(professor));
    }

    @Override
    public ProfessorDto createProfessorAccountUser(ProfessorDto professorDto) {
        accountUserRepository.save(professorDto.getAccountUser());
        Professor professor;
        professor = ProfessorMapper.toEntity(professorDto);
        return ProfessorMapper.toDto(professorRepository.save(professor));
    }
}

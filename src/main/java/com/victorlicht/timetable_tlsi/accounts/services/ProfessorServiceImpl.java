package com.victorlicht.timetable_tlsi.accounts.services;

import com.victorlicht.timetable_tlsi.accounts.dtos.ProfessorDto;
import com.victorlicht.timetable_tlsi.accounts.mappers.ProfessorMapper;
import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.accounts.repositories.AccountUserRepository;
import com.victorlicht.timetable_tlsi.accounts.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository professorRepository;

    private final AccountUserRepository accountUserRepository;


    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository, AccountUserRepository accountUserRepository) {
        this.professorRepository = professorRepository;
        this.accountUserRepository = accountUserRepository;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
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

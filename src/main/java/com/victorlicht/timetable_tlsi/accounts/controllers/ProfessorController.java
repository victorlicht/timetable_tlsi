package com.victorlicht.timetable_tlsi.accounts.controllers;

import com.victorlicht.timetable_tlsi.accounts.dtos.ProfessorDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Grade;
import com.victorlicht.timetable_tlsi.accounts.services.ProfessorService;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/admin/create")
    public ResponseEntity<ProfessorDto> createAccountUser(@RequestBody ProfessorDto professorDto)
    {
        ProfessorDto createdUser = professorService.createProfessorAccountUser(professorDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/admin/find")
    public ResponseEntity<Page<ProfessorDto>> findUsersDynamically(
            @RequestParam(required = false) AccountUser accountUser,
            @RequestParam(required = false) boolean isAdmin,
            @RequestParam(required = false) Set<Course> courses,
            @RequestParam(required = false) Set<StudentGroup> studentGroups,
            @RequestParam(required = false) int yearOfTeaching,
            @RequestParam(required = false) Grade grade,
            @RequestParam(required = false) String orderByField,
            @RequestParam(defaultValue = "ASC") String sortOrder,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {

        if (!(pageSize == 10 || pageSize == 25 || pageSize == 50)) {
            return ResponseEntity.badRequest().build();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<ProfessorDto> users = professorService.findProfessorsDynamically(
                        accountUser, courses, studentGroups, grade,
                        isAdmin, yearOfTeaching, orderByField, sortOrder,
                        pageable
        );
        return ResponseEntity.ok(users);
    }
}

package com.victorlicht.timetable_tlsi.classrooms.controller;

import com.victorlicht.timetable_tlsi.classrooms.dto.ClassroomDto;
import com.victorlicht.timetable_tlsi.classrooms.model.ClassroomType;
import com.victorlicht.timetable_tlsi.classrooms.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms() {
        List<ClassroomDto> classrooms = classroomService.findAll();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClassroomDto> createClassroom(@RequestBody ClassroomDto classroomDto) {
        ClassroomDto createdClassroom = classroomService.createClassroom(classroomDto);
        return new ResponseEntity<>(createdClassroom, HttpStatus.CREATED);
    }

    @DeleteMapping("/{classroomType}/{classroomNumber}")
    public ResponseEntity<Void> deleteClassroomByTypeAndNumber(@PathVariable ClassroomType classroomType,
                                                               @PathVariable int classroomNumber) {
        classroomService.deleteClassroomByClassroomNumberAndClassroomType(classroomNumber, classroomType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/type/{classroomType}")
    public ResponseEntity<List<ClassroomDto>> findByClassroomType(@PathVariable ClassroomType classroomType) {
        List<ClassroomDto> classrooms = classroomService.findByClassroomType(classroomType);
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @GetMapping("/{classroomNumber}")
    public ResponseEntity<ClassroomDto> findByClassroomNumber(@PathVariable int classroomNumber) {
        ClassroomDto classroom = classroomService.findClassroomByClassroomNumber(classroomNumber);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }
}
